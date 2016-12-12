$().ready(function () {
        $('#reg-form')
            .form({
                fields: {
                    login_name : {
                        identifier: 'login_name',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : '昵称不能为空'
                            }
                        ]
                    },
                    mobile : {
                        identifier: 'mobile',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : '手机号不能为空'
                            }
                        ]
                    },
                    credence : {
                        identifier: 'credence',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : '密码不能为空'
                            }
                        ]
                    }
                },
                inline: true,
                on: 'blur'
            });
});