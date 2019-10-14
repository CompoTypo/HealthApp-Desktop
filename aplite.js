const http = require('http');
const { Console } = require('console');
const os = require( 'os' );
const networkInterfaces = os.networkInterfaces( );
const port = 8000;
const hostname = networkInterfaces[0];
console.log(hostname);


const server = http.createServer((req, res) => {
	var url = req.url;
	console.log(url);
	// if (url === hostname + ':' + port + '/register') {}
	  
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
	  

  res.end("User info recieved\n");
});

server.listen(port, hostname, () => {
  console.log("Server running at http:", hostname, port);
});

