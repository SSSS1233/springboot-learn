/**
 * Created by Intellij IDEA.
 * @Author SUBING
 * @Date 2018/4/5
 * @Comment js文件，用于页面发送ajax请求,动态更新
 */

//定义一个avalonjs的控制器
var viewmodel = avalon.define({
    //id必须和页面上定义的ms-controller名字相同，否则无法控制页面
    $id: "viewmodel",
    datalist: {},
    text: "请求数据",

    request: function () {
        $.ajax({
            type:"",
            url: "",    //向springboot请求数据的url
            data: {},
            success: function (data) {
               // $('button').removeClass("btn-primary").addClass("btn-success").attr('disabled', true);
                viewmodel.datalist = data;
               // viewmodel.text = "数据请求成功，已渲染";
            }
        });
    }
});