$().ready(function () {
        $('#reg-form')
            .form({
                fields: {
                    name : {
                        identifier: 'name',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : '昵称不能为空'
                            }
                        ]
                    },
                    phone : {
                        identifier: 'phone',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : '手机号不能为空'
                            }
                        ]
                    },
                    password : {
                        identifier: 'password',
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