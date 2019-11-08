const sqlite = require('sqlite3').verbose();
const db = new sqlite.Database('./src/backend/sqlite.db');

function end(err, result, res) {
    if (err) {
        console.log(sql, params);
        console.log(err.name, err.message, err.stack);
    } else {
        res.statusCode = 200;
        res.setHeader('Content-Type', 'text/plain');
        console.log(result);
        res.end(JSON.stringify(result));
    }
}

exports.find = (sql, params, res) => {
    db.all(sql, params, (err, result) => 
        end(err, result, res));
}

exports.check = (sql, params) => {
    return new Promise((resolve, reject) => {
        db.get(sql, params, )
    });
}

exports.insert = (sql, params, res) => {
    db.run(sql, params, (err, result) => 
        end(err, result, res));
}