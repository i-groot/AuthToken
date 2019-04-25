// set timeout
var _TIMEOUT = 120 * 1000;

var _actionEnum = {
    POST: "POST",
    GET: "GET",
    PUT: "PUT",
    DELETE: "DELETE"
}
/**
 * response code
 * @type {{OPER_FAIL: 0, OPERA_SUCCESS: 1}}
 * @private
 */
var _retCode = {
    OPER_FAIL: 0,
    OPERA_SUCCESS: 1
}
// responseBody
function CallbackRsp() {
    this.retCode = _retCode.OPER_FAIL;
    this.data = null;
    this.exception = null;
}
// construct responseBody and do callback method
CallbackRsp.invoke = function (callback, formerRsp, data) {
    if (null == callback){
        return;
    }
    var newRsp = new CallbackRsp();
    if (null != formerRsp) {
        newRsp.retCode = formerRsp.retCode;
        newRsp.exception = formerRsp.exception;
    }
    if (null != data) {
        newRsp.data = data;
    }
    callback(newRsp);
}

/**
 * syn Post
 * @param url
 * @param request
 * @param callback
 */
function sendSynPost(url, request, callback) {
    send(url,_actionEnum.POST,false, request, callback, _TIMEOUT);
}

/**
 * syn Get
 * @param url
 * @param callback
 */
function sendSynGet(url,callback) {
    send(url,_actionEnum.GET,false, null, callback, _TIMEOUT);
}

/**
 * syn Put
 * @param url
 * @param request
 * @param callback
 */
function sendSynPut(url,request,callback) {
    send(url,_actionEnum.PUT,false, request, callback, _TIMEOUT);
}

/**
 * syn Delete
 * @param url
 * @param callback
 */
function sendSynDelete(url,callback) {
    send(url,_actionEnum.DELETE,false, null, callback, _TIMEOUT);
}

/**
 * asyn Post
 * @param url
 * @param request
 * @param callback
 */
function sendAsynPost(url, request, callback) {
    send(url,_actionEnum.POST,true, request, callback, _TIMEOUT);
}

/**
 * asyn Get
 * @param url
 * @param callback
 */
function sendAsynGet(url,callback) {
    send(url,_actionEnum.GET,true, null, callback, _TIMEOUT);
}

/**
 * asyn Put
 * @param url
 * @param request
 * @param callback
 */
function sendAsynPut(url,request,callback) {
    send(url,_actionEnum.PUT,true, request, callback, 3000);
}

/**
 * asyn Delete
 * @param url
 * @param callback
 */
function sendAsynDelete(url,callback) {
    send(url,_actionEnum.DELETE,true, null, callback, 3000);
}

/**
 * send ajax
 * @param url
 * @param method
 * @param isAsync
 * @param request
 * @param callback
 * @param timeout
 */
function send(url, method, isAsync, request, callback, timeout) {

    if (request){
        request = JSON.stringify(request);
    }

    var setting = {
        url: formatUrl(url),
        type: method,
        async: isAsync,
        data: request,
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        timeout: timeout ? timeout: 5000,
        success: function (result) {
            var rsp = new CallbackRsp();
            rsp.retCode = _retCode.OPERA_SUCCESS;
            rsp.exception = null;
            CallbackRsp.invoke(callback, rsp, result);
        },
        error: function (xhr,status,error) {
            var rsp = new CallbackRsp();
            rsp.exception = error;
            CallbackRsp.invoke(callback, rsp);
        }
    };
    $.ajax(setting);
}

function formatUrl(url) {
    if (!url) {
        alert('url is empty.')
        return new Error('url is empty.');
    }
    var random = Math.random().toString(16).substring(2);
    if (url.indexOf('?') == -1) {
        url += "?random=" + random;
    } else {
        url += "&random=" + random;
    }
    return url;
}
