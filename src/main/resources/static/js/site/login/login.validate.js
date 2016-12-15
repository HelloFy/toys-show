var vm = new Vue({
    el: '.ui.middle.aligned.center.aligned.grid',
    data: {
        loginName: '',
        credence: '',
        mobile: '',
        password:'',
        username:'',
        click: false,
        hidden: true,
        visible:false,
        _csrf:''
    },
    mounted:function () {
        this._csrf = document.getElementById('csrf-hid').value;
    }
});

$.fn.form.settings.rules.userIsExist = function (value) {
    var flag;
    if (value == '') {
        return;
    }
    fetch('/user/existName',{
        method: "POST",
        body: '_csrf='+vm._csrf+'&loginName='+vm.loginName,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        credentials: "same-origin"
    }).then(function(response) {
        response.json().then(function(data) {
            flag = data.result;
        });
        return;
    }, function(error) {
        error.message //=> String
    });
    return !flag;
};
$.fn.form.settings.rules.mobileIsExist = function (value) {
    var flag;
    if (value == '') {
        return;
    }
    $.ajax({
        async: false,
        url: "/user/existMobile",
        type: "POST",
        dataType: "json",
        data: {
            _csrf: vm._csrf,
            mobile: value
        },
        success: function (data) {
            flag = data.result;
        }
    });
    return !flag;
};
$(document).ready(function () {
    $('#reg-form')
        .form({
            fields: {
                loginName: {
                    identifier: 'loginName',
                    rules: [
                        {
                            type: 'empty',
                            prompt: '昵称不能为空'
                        },
                        {
                            type: 'userIsExist',
                            prompt: '昵称已经存在'
                        },
                        {
                            type: 'minLength[2]',
                            prompt: '昵称长度不够，2-10个字符'
                        },
                        {
                            type: 'maxLength[10]',
                            prompt: '昵称长度太长，2-10个字符'
                        }
                    ]
                },
                mobile: {
                    identifier: 'mobile',
                    rules: [
                        {
                            type: 'empty',
                            prompt: '手机号不能为空'
                        },
                        {
                            type: 'regExp',
                            value: '/^1[3|4|5|7|8][0-9]{9}$/',
                            prompt: '手机号不符合规则'
                        },
                        {
                            type: 'mobileIsExist',
                            prompt: '手机号已经注册过'
                        }
                    ]
                },
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
                $.ajax({
                    url: '/register',
                    type: 'POST',
                    data: {
                        _csrf: $('#csrf-reg-hid').val(),
                        loginName: vm.loginName,
                        credence: vm.credence,
                        mobile: vm.mobile
                    },
                    dataType: 'json',
                    success: function (data) {
                        if (data.result == 'success') {
                            vm.click = false;
                            vm.loginName = '';
                            vm.credence = '';
                            vm.mobile = '';
                            $('.small.test.modal')
                                .modal({
                                    onApprove: function () {
                                        $('.ui.secondary.pointing.menu .item').tab(
                                            'change tab', 'login'
                                        );
                                    }
                                }).modal('show');
                        }
                        else {
                            vm.click = false;
                            vm.hidden = false;
                            vm.visible = true;
                        }
                    },
                    error: function (data) {
                        vm.click = false;
                        vm.hidden = false;
                        vm.visible = true;
                    }
                })
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
                $.ajax({
                    url: '/login',
                    type: 'POST',
                    data: {
                        _csrf: $('#csrf-reg-hid').val(),
                        username: vm.username,
                        password: vm.password,
                    },
                    dataType: 'json',
                    success: function (data) {
                        if (data.result == 'fail') {
                            vm.hidden = false;
                            vm.visible = true;
                            vm.click=false;
                        }
                        else {
                            window.location='/';
                        }
                    },
                    error: function (data) {
                        vm.hidden = false;
                        vm.visible = true;
                    }
                })
            }
        });
});