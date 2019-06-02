$(document).ready(function () {
    $("#LoginButton").click(function () {
        $(".login").show().siblings().hide();
        $(".message-box input").val("");
    });

    $("#RegisterButton").click(function () {
        $(".register").show().siblings().hide();
        $(".message-box input").val("");
    });

    $(".forgot-pwd-btn").click(function () {
        alert("你自己记性不好，怪我喽？！-.-")
    });

    $("#LoginForm").validate({
        // debug: true, //调试模式取消submit的默认提交功能
        //errorClass: "label.error", //默认为错误的样式类为：error
        focusInvalid: false, //当为false时，验证无效时，没有焦点响应
        onkeyup: false,
        submitHandler: function (form) {   //表单提交句柄,为一回调函数，带一个参数：form
            var userName=$("#LoginUsername").val();
            var password=$("#LoginPassword").val();
            var data={
                userName:userName,
                password:password
            };

            // data = data.serializeJSON();

            $.ajax({
                type: "POST", //GET或POST,
                async:true, //默认设置为true，所有请求均为异步请求。
                url: "http://localhost:8080/api/login",
                data:  JSON.stringify(data),
                dataType: "json", //xml、html、script、jsonp、text,
                contentType: "application/json;charset=utf-8",
                beforeSend:function(){},
                complete:function(){},
                success: function(data) {
                    window.location.href="/view/hello.html";
                },
                error:function(){
                    alert(2)
                },
            });
        },
        rules: {
            LoginUsername: {
                required: true,
                rangelength:[6,12]
            },
            LoginPassword: {
                required: true,
                rangelength:[6,12]
            },
            LoginCode: {
                required: true,
                rangelength:[4,4]
            }
        },
        messages:{
            LoginUsername:{
                required:"请输入用户名",
                rangelength:"请输6-12位用户名"
            },
            LoginPassword:{
                required: "请输入密码",
                rangelength:"请输6-12位密码"
            },
            LoginCode:{
                required: "请输入验证码",
                rangelength:"验证码格式不对"
            }
        }
    });

    $("#RegisterForm").validate({
        // debug: true, //调试模式取消submit的默认提交功能
        //errorClass: "label.error", //默认为错误的样式类为：error
        focusInvalid: false, //当为false时，验证无效时，没有焦点响应
        onkeyup: false,
        submitHandler: function () {
            //表单提交句柄,为一回调函数，带一个参数：form

        },
        rules: {
            RegisterUsername: {
                required: true,
                rangelength:[6,12]
            },
            RegisterPassword: {
                required: true,
                rangelength:[6,12]
            },
            RegisterPassword2: {
                required: true,
                equalTo:"#RegisterPassword"
            },
            RegisterCode: {
                required: true,
                rangelength:[4,4]
            }
        },
        messages:{
            RegisterUsername:{
                required:"请输入用户名",
                rangelength:"请输6-12位用户名"
            },
            RegisterPassword:{
                required: "请输入密码",
                rangelength:"请输6-12位密码"
            },
            RegisterPassword2:{
                required: "请确认密码",
                equalTo:"请输入相同密码"
            },
            RegisterCode:{
                required: "请输入验证码",
                rangelength:"验证码格式不对"
            }
        }
    })
})