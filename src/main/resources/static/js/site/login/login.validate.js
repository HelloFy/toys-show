var vm = new Vue({
    el: '#reg-button',
    data: {
        name:'注册'
    },
    methods: {
        doRegister: function (){

        }
    }
});

$.fn.form.settings.rules.userIsExist = function(value){
    var flag;
    if(value == ''){
        return;
    }
    $.ajax({
        async : false,
        url: "/user/existName",
        type: "POST",
        dataType: "json",
        data: {
            _csrf:$('#csrf-reg-hid').val(),
            loginName : value
        },
        success: function(data){
            flag = data.result;
        }
    });
    return !flag;
};;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

$.fn.form.settings.rules.mobileIsExist = function(value){
    var flag;
    if(value == ''){
        return;
    }
    $.ajax({
        async : false,
        url: "/user/existMobile",
        type: "POST",
        dataType: "json",
        data: {
            _csrf:$('#csrf-reg-hid').val(),
            mobile : value
        },
        success: function(data){
            flag = data.result;
        }
    });
    return !flag;
};;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
$().ready(function () {
        $('#reg-form')
            .form({
                fields: {
                    loginName : {
                        identifier: 'loginName',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : '昵称不能为空'
                            },
                            {
                                type   : 'userIsExist',
                                prompt : '昵称已经存在'
                            },
                            {
                                type   : 'minLength[2]',
                                prompt : '昵称长度不够，2-10个字符'
                            },
                            {
                                type   : 'maxLength[10]',
                                prompt : '昵称长度太长，2-10个字符'
                            }
                        ]
                    },
                    mobile : {
                        identifier: 'mobile',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : '手机号不能为空'
                            },
                            {
                                type   : 'mobileIsExist',
                                prompt : '手机号已经注册过'
                            }
                        ]
                    },
                    credence : {
                        identifier: 'credence',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : '密码不能为空'
                            },
                            {
                                type   : 'minLength[6]',
                                prompt : '密码长度不够，6-16个字符'
                            },
                            {
                                type   : 'maxLength[16]',
                                prompt : '密码长度太长，2-16个字符'
                            }
                        ]
                    }
                },
                inline: true,
                on: 'blur'
            });
});