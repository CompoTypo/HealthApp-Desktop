const sqlite = require('sqlite3').verbose();
const util = require('util');
const db = new sqlite.Database('./sqlite.db');

exports.select = (sql, params, res) => {
    db.run(sql, params, (err, result) => {
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

exports.insert = (sql, params, res) => {
    console.log(params[2]);
    db.run(sql, params, (err) => {
        if (err) {
            console.log(sql);
            console.log(err.name, err.message, err.stack);
        } else {
            console.log('but');
            select("select distinct * from Users where Uname=? AND Hash=?", [params[0][1], params[1][1]], res);
        }
    });
}