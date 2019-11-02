const http = require('http');
const fs = require('fs');
const sqlite = require('sqlite3').verbose();
const port = 8000;
const hostname = "127.0.0.1";

const db = new sqlite.Database('./sqlite.db');

getQuery = (sql, params, res) => {
  db.get(sql, params, (err, result) => {
    if (err) {
      console.log(err);
    } else {
      res.statusCode = 200;
      res.setHeader('Content-Type', 'text/plain');
      console.log(result);
      res.end(JSON.stringify(result));
    }
  });
}

sendAdminLogin = (request, response) => {
  response.end(fs.readFileSync("./html/index.html"), fs.readFileSync("./html/styles.css"), fs.readFileSync("./html/assets/img/red-cross.png"));
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
    getQuery("select distinct * from Users where Hash=?", elArr[1][1], response);
    // at this point, `body` has the entire request body stored in it as a string
  });
}

registerUser = (request, response) => {
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
    getQuery("insert into users (Fname, Lname, Uname, Email, Hash, DOB, Sex, Race, Type) values (?, ?, ?, ?, ?, ?, ?, ?, ?)", 
      [elArr[0][1], elArr[1][1], elArr[2][1], elArr[3][1], elArr[4][1], elArr[5][1], elArr[6][1], elArr[7][1], elArr[8][1], elArr[9][1]], 
      response);
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

