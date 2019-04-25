var bookUrl = "/app/v1/book";
var userUrl = "/app/v1/user";
var healthUrl = "/app/v1/health";

//-------user--------
/**
 * add user
 * @param req
 * @param callback
 */
var addUser = function (req, callback) {
    var url = userUrl;
    sendAsynPost(url, req, callback);
}

/**
 * login
 * @param req
 * @param callback
 */
var login = function (req, callback) {
    var url = userUrl + "/login";
    sendSynPost(url, req, callback);
}

/**
 * logout
 * @param callback
 */
var logout = function (callback) {
    var url = userUrl + "/logout";
    sendSynPut(url, null, callback);
}


//-------book--------
/**
 * add book
 * @param req
 * @param callback
 */
var addBook = function (req, callback) {
    var url = bookUrl;
    sendAsynPost(url, req, callback);
}
/**
 * update book num
 * @param req
 * @param param
 * @param callback
 */
var updBook = function (req, param, callback) {
    var url = bookUrl+ "/" + param;
    sendAsynPut(url, req, callback);
}

/**
 * delete book
 * @param param
 * @param callback
 */
var delBook = function (param, callback) {
    var url = bookUrl+ "/" + param;
    sendAsynDelete(url, callback);
}

/**
 * get book by id
 * @param param
 * @param callback
 */
var queryBookById = function (param, callback) {
    var url = bookUrl+ "/" + param;
    sendAsynGet(url, callback);
}

/**
 * get books
 * @param param
 * @param callback
 */
var queryBooks = function (callback) {
    var url = bookUrl;
    sendAsynGet(url, callback);
}

var healthCheck = function (callback) {
    var url = "/app/v1/health"
    sendAsynGet(url, callback);
}