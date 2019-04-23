function test(url, params, callback) {
    if (params){
        url += "?params=" + params;
    }
    asynGet(url, null, function (rsp) {
        callback(rsp)
    });
}