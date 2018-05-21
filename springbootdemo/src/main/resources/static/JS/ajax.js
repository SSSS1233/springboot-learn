/**
 * Created by Administrator on 2018/4/5.
 */
$(document).ready(function () {
    var num=0;
    $("#down").click(function () {
        var name = $("#name").val();
        num=num+1;
        var user = {num :num};
        $.ajax({
            url: "check.do",
            type: "post",
            data: user,
            dataType: "json",
            success: function (data) {
                viewmodel.datalist = data;
            }
        })
    })

    $("#up").click(function () {
        var name = $("#name").val();
        num=num-1;
        if(num<=0)
        {
            num=1
        }
        var user = {num :num};
        $.ajax({
            url: "check.do",
            type: "post",
            data: user,
            dataType: "json",
            success: function (data) {
                viewmodel.datalist = data;
            }
        })
    })
});