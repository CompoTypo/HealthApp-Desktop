const sqlite = require('sqlite3').verbose();
const util = require('util');
const db = new sqlite.Database('./src/backend/sqlite.db');

exports.select = (sql, params, res) => {
    db.get(sql, params, (err, result) => {
        if (err) {
            console.log(err);
        } else {
            res.statusCode = 200;
            res.setHeader('Content-Type', 'text/plain');
            console.log(result, process.cwd());
            res.end(JSON.stringify(result), process.cwd());
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
            console.log(params[0][1], params[1][1]);
            select("select * from users where Uname=? AND Hash=?", [params[0][1], params[1][1]], res);
        }
    });
}