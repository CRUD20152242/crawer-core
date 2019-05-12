//启动任务的配置
$("#startCrawl").click(startCrawl)


//启动任务
function startCrawl() {
    //目标网址
    var seed = $("#seed").val();
    var regex1 = $("#regex1").val();
    var regex2 = $("#regex2").val();
    var regex3 = $("#regex3").val();
    var regex4 = $("#regex4").val();
    var deep = $("#deep").val();
    var turbo = $("#useJs").val();
    if(turbo!=true){
        turbo = false;
    }else {
        turbo=true
    }
    var fileName = $("#taskName").val();
    var threads = $("#ThreadsNum").val();
    var  rule1 =  $("#rule1").val();
    var  rule2 =  $("#rule2").val();
    var  rule3 =  $("#rule3").val();
    var  rule4 =  $("#rule4").val();
    $.ajax({
        url : "http://localhost:8080/spider/startCrawl",
        type : "get",
        data : {
            "seed":seed,
            "regex1":regex1,
            "regex2":regex2,
            "regex3":regex3,
            "regex4":regex4,
            "deep":deep,
            "turbo":turbo,
            "fileName":fileName,
            "threads":threads,
            "rule1":rule1,
            "rule2":rule2,
            "rule3":rule3,
            "rule4":rule4,
        },
        dataType:"json",
        success : function (f) {
            if(f=="success"){
                alert("操作成功，任务开始执行")
            }else {
                alert(f)
            }
        },
        error:function (f) {
            alert("未知错误 联系管理员 qq 2314449060  错误码："+f.state())
        }
    });

}
