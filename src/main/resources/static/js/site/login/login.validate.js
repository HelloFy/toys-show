var vm = new Vue({
    el: '.ui.middle.aligned.center.aligned.grid',
    data: {
        loginName: '',
        credence: '',
        mobile: '',
        password: '',
        username: '',
        click: false,
        hidden: true,
        visible: false,
        uNameValid: true,
        mobileValid: true,
        _csrf: '',
        lnmsg: '',
        mbmsg: ''
    },
    mounted: function () {
        this._csrf = document.getElementById('csrf-hid').value;
    },
    methods: {
        focusInLoginName: function () {
            vm.uNameValid = true;
        },
        blurInLoginName: function () {
            if (vm.loginName === '') {
                vm.lnmsg = '昵称不能为空';
                vm.uNameValid = false;
            }
            else if (vm.loginName.length < 2) {
                vm.lnmsg = '昵称长度太短(2-8字符)';
                vm.uNameValid = false;
            }
            else if (vm.loginName.length > 8) {
                vm.lnmsg = '昵称长度太长(2-8字符)';
                vm.uNameValid = false;
            }
            else {
                fetch('/user/existName', {
                    method: "POST",
                    body: '_csrf=' + vm._csrf + '&loginName=' + vm.loginName,
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    credentials: "same-origin"
                }).then(function (response) {
                    response.json().then(function (data) {
                        flag = data.result;
                        vm.lnmsg = '昵称已经被占用';
                        vm.uNameValid = !flag;
                    });

                }, function (error) {
                    error.message;;;;;;;;; //=> String
                });
            }
        },
        focusInMobile: function () {
            vm.mobileValid = true;
        },
        blurInMobile: function () {
            if (vm.mobile === '') {
                vm.mbmsg = '手机号不能为空';
                vm.mobileValid = false;
            }
            else if (!(/^1(3[0-9]|4[57]|5[0-35-9]|8[0-9]|7[0-9])\d{8}$/.test(vm.mobile))) {
                vm.mbmsg = '手机号不正确';
                vm.mobileValid = false;
            }
            else {
                fetch('/user/existMobile', {
                    method: "POST",
                    body: '_csrf=' + vm._csrf + '&mobile=' + vm.mobile,
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    credentials: "same-origin"
                }).then(function (response) {
                    response.json().then(function (data) {
                        flag = data.result;
                        vm.mobileValid = !flag;
                        vm.mbmsg = '手机号已经被注册';

                    });

                }, function (error) {
                    error.message;;;;;;;;; //=> String
                });
            }
        }
    }
});
$(document).ready(function () {
    $('#reg-form')
        .form({
            fields: {
                credence: {
                    identifier: 'credence',
                    rules: [
                        {
                            type: 'empty',
                            prompt: '密码不能为空'
                        },
                        {
                            type: 'minLength[6]',
                            prompt: '密码长度不够，6-16个字符'
                        },
                        {
                            type: 'maxLength[16]',
                            prompt: '密码长度太长，2-16个字符'
                        }
                    ]
                }
            },
            inline: true,
            on: 'blur',
            onSuccess: function (e) {
                e.preventDefault();
                vm.click = true;
                if (vm.loginName == '' && vm.mobile == '') {
                    vm.uNameValid = false;
                    $('loginName').focus();
                    vm.mobileValid = false;
                    vm.lnmsg = '昵称不能为空';
                    vm.mbmsg = '手机号不能为空';
                    vm.click = false;

                }
                else if (vm.mobile == '') {
                    vm.mobileValid = false;
                    $('mobile').focus();
                    vm.click = false;

                }
                else if (vm.loginName == '') {
                    vm.uNameValid = false;
                    $('loginName').focus();
                    vm.click = false;

                }
                else {
                    if (vm.mobileValid && vm.uNameValid) {
                        fetch('/register', {
                            method: "POST",
                            body: '_csrf=' + vm._csrf + '&mobile=' + vm.mobile + '&credence=' + vm.credence + '&loginName=' + vm.loginName,
                            headers: {
                                'Accept': 'application/json',
                                'Content-Type': 'application/x-www-form-urlencoded'
                            },
                            credentials: "same-origin"
                        }).then(function (response) {
                            response.json().then(function (data) {
                                if (data.result == 'success') {
                                    $('.small.test.modal')
                                        .modal({
                                            onApprove: function () {
                                                $('.ui.secondary.pointing.menu .item').tab(
                                                    'change tab', 'login'
                                                );
                                            }
                                        }).modal('show');
                                    vm.click = false;
                                }
                                else {
                                    vm.click = false;
                                    vm.hidden = false;
                                    vm.visible = true;
                                }
                            });

                        }, function (error) {
                            error.message;;;;;;;;; //=> String
                        });
                    }
                    else if (!vm.uNameValid) {
                        $('loginName').focus();
                    }
                    else {
                        $('mobile').focus();
                    }

                }


            }
        });
    $('#log-form')
        .form({
            fields: {
                username: {
                    identifier: 'username',
                    rules: [
                        {
                            type: 'empty',
                            prompt: '登录名不能为空'
                        },
                        {
                            type: 'maxLength[25]',
                            prompt: '登录名过长'
                        }
                    ]
                },
                password: {
                    identifier: 'password',
                    rules: [
                        {
                            type: 'empty',
                            prompt: '密码不能为空'
                        },
                        {
                            type: 'minLength[6]',
                            prompt: '密码长度不够，6-16个字符'
                        },
                        {
                            type: 'maxLength[16]',
                            prompt: '密码长度太长，2-16个字符'
                        }
                    ]
                }
            },
            inline: true,
            onSuccess: function (e) {
                e.preventDefault();
                vm.click = true;
                fetch('/login', {
                    method: "POST",
                    body: '_csrf=' + vm._csrf + '&username=' + vm.username + '&password=' + vm.password,
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    credentials: "same-origin"
                }).then(function (response) {
                    response.json().then(function (data) {
                        if (data.result == 'fail') {
                            vm.hidden = false;
                            vm.visible = true;
                            vm.click = false;
                        }
                        else {
                            window.location = '/';
                        }
                    });

                }, function (error) {
                    error.message;;;;;;;;; //=> String
                });
            }
        });
});