const sqlite = require('sqlite3').verbose();
const util = require('util');
const db = new sqlite.Database('./src/backend/sqlite.db');
const http = require('http');
const fs = require('fs');
const port = 8000;
const hostname = "127.0.0.1";

sendAdminLogin = (request, response) => {
  response.end(fs.readFileSync("./html/index.html"));
}

_query = (sql, params, res) => {
  console.log(params);
  db.run(sql, params, (err, result) => {
    if (err) {
      console.log(sql, params);
      console.log(err.name, err.message, err.stack);
    } else {
      res.statusCode = 200;
      res.setHeader('Content-Type', 'text/plain');
      console.log(result);
      res.end(JSON.stringify(result));
    }
  });
}

async function _readBody(request) {
  let body = [];
  request.on('data', (chunk) => {
    body.push(chunk);
  }).on('end', () => {
    body = Buffer.concat(body).toString();
    body = body.substring(1, body.toString().length - 1).split(","); // trims brackets and divides each pair into . . .
    console.log(body);
    return body;
  });
}

async function processLogin(request, response) {
  let body = await _readBody(request);
  elArr = [];
  console.log(body);
  body.forEach(element => {
    element = element.replace(/\s+/g, ''); // get rid of whitespace
    element = element.split('='); // split the pairs, creating a 2d arr
    elArr.push(element); // . . . an array element
  }).catch(reason => {console.log(reason)});
  _query("select distinct * from users where Uname=? AND Hash=?", [elArr[0][1], elArr[1][1]], response);
  
  // at this point, `body` has the entire request body stored in it as a string
};


async function registerUser(request, response) {
  keyInserts = valInserts = "";
  let body = await _readBody(request);
  elArr = [];

  body.forEach((element, ind) => {
    if (ind !== 0) {
      keyInserts += ", ";
      valInserts += ", ";
    }
    element = element.replace(/\s+/g, ''); // get rid of whitespace
    element = element.split('='); // split the pairs, creating a 2d arr
    elArr.push(element);
    keyInserts += element[0];
    valInserts += element[1]; // . . . an array element
  });
  sql = "insert into users (" + keyInserts + ") values (" + valInserts + ") ESCAPE @";
  _query(sql, elArr, response);
  // at this point, `body` has the entire request body stored in it as a string
}.catch(reason => {console.log(reason)});

const server = http.createServer((req, res) => {
  if (req.method == 'GET') {
    //if (req.headers.host === hostname + ":" + port) {
    sendAdminLogin(req, res);
    //}
  } else if (req.method == 'PUT') {
    if (req.url === '/login') {
      processLogin(req, res);
    }
  } else if (req.method === 'POST') {
    if (req.url === '/register') {
      registerUser(req, res);
    }
  } else if (req.method === 'DELETE') {}
});

server.listen(port, hostname, () => {
  console.log("Server running at http://" + hostname + ':' + port);
});