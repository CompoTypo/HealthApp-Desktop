const queries = require('./queries');
const http = require('http');
const fs = require('fs');
const port = 8000;
const hostname = "127.0.0.1";

sendAdminLogin = (request, response) => {
  response.end(fs.readFileSync("./html/index.html"));
}

processLogin = (request, response) => {
  let body = [];
  request.on('data', (chunk) => {
    body.push(chunk);
  }).on('end', () => {
    body = Buffer.concat(body).toString();
    body = body.substring(1, body.toString().length - 1).split(","); // trims brackets and divides each pair into . . .
    elArr = [];
    body.forEach(element => {
      element = element.replace(/\s+/g, ''); // get rid of whitespace
      element = element.split('='); // split the pairs, creating a 2d arr
      elArr.push(element);                                           // . . . an array element
    });
    queries.select("select distinct * from users where Uname=? AND Hash=?", [params[0][1], params[1][1]], response);
    // at this point, `body` has the entire request body stored in it as a string
  });
}

registerUser = (request, response) => {
  keyInserts = valInserts = ""; 
  let body = [];
  request.on('data', (chunk) => {
    body.push(chunk);
  }).on('end', () => {
    body = Buffer.concat(body).toString();
    body = body.substring(1, body.toString().length - 1).split(","); // trims brackets and divides each pair into . . .
    elArr = [];
    body.forEach( (element, ind) => {
      if (ind !== 0) {keyInserts += ", "; valInserts += ", "; }
      element = element.replace(/\s+/g, ''); // get rid of whitespace
      element = element.split('='); // split the pairs, creating a 2d arr
      elArr.push(element);
      keyInserts += element[0]; valInserts += element[1];                                          // . . . an array element
    });
    sql = "insert into users (" + keyInserts + ") values (" + valInserts + ")";
    queries.insert(sql, elArr, response);
    // at this point, `body` has the entire request body stored in it as a string
  });
}

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
  } else if (req.method === 'DELETE') { }
});

server.listen(port, hostname, () => {
  console.log("Server running at http://" + hostname + ':' + port);
});

