import express from 'express';
import router from './Rutas/Interpreter'
// import routerF from '../Rutas/Files'
const app = express();
const port = 3000;
let cors = require('cors')
app.use(cors())
app.use(express.json())
app.get('/', (req, res) => {
    res.send('Hola mundo');
})
app.use('/interpreter', router)
// app.use('/files', routerF)
app.listen(port, () => {
    try {
        return console.log(`Server is running in port ${port}`);
    } catch (error) {
        return console.error(error);
    }
});