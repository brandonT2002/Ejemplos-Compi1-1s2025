var fs = require('fs');
var parser = require('../Lenguaje/Parser');
console.log(`Resultado
    ${parser.parse(`
        !((15 == 15) && (6 == 16))
        15 + 15
        (16 / 4) * 2
        5 - 45
        15 * 15
        15 / 15
    `)}
`);

// fs.readFile('Test.txt', 'utf8', function (err: any, data: any) {
//     if (err)
//         throw err;
//     console.log(parser.parse(data));
// });