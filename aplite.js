const http = require('http');
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

const server = http.createServer((req, res) => {
  if (req.method == 'GET') {
  } else if (req.method == 'PUT') {
    if (req.url === '/login') {
      let b = processLogin(req, res);
    }
  } else if (req.method === 'POST') {
    if (req.url === '/register') {
      console.log(url, "works");
      res.statusCode = 200;
      res.setHeader('Content-Type', 'text/plain');
      res.end("Registration info recieved\n");
    }
  } else if (req.method === 'DELETE') { }
});

server.listen(port, hostname, () => {
  console.log("Server running at http://" + hostname + ':' + port);
});

