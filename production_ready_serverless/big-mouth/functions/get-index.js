'use strict';
const co = require("co")
const Promise = require("bluebird")
const fs = Promise.promisifyAll(require("fs"))


module.exports.hello = co.wrap(function* (event, context, callback) { 
  let html = yield loadHtml();
  const response = {
    statusCode: 200,
    body: html,
    headers: {
      'Content-Type': 'text/html; charset=UTF-8'
    }
  };
  callback(null, response)

});
