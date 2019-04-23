function synPost(url, request, callback) {
    send(url,"POST",false, request, callback, 3000);
}

function synGet(url, request, callback) {
    send(url,"GET",false, null, callback, 3000);
}

function asynPost(url, request, callback) {
    send(url,"POST",true, request, callback, 3000);
}

function asynGet(url, request, callback) {
    send(url,"GET",true,null, callback, 3000);
}

function send(url, method, isAsync, request, callback, timeout) {

    if (request){
        // request = JSON.stringify(request);
    }

    var setting = {
        url: url,
        type: method,
        async: isAsync,
        data: request,
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        timeout: timeout ? timeout: 5000,
        success: function (result,status,xhr) {
            console.log("-------success------")
            var rsp = RspData(result, 1);
            callback(rsp);
        },
        error: function (xhr,status,error) {
            console.log("-------error------")
            console.log(error)
        }
    };
    $.ajax(setting);
}

var RspData = function (data, status) {
    var rsp = {};
    // 0失败  1成功
    rsp.status = 0;
    if (status)
    {
        rsp.status = status;
    }
    rsp.data = data;
    return rsp;
};