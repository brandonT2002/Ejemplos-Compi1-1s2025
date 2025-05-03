import express from 'express'
import { Controlador } from '../Controlador/Controlador'
const router = express.Router()
const interpreter: Controlador = new Controlador()
router.get('/', interpreter.running)
// router.post('/parser', interpreter.parser)
router.post('/parserFile', interpreter.parserFile)
// router.get('/getAST', interpreter.getAST)
router.get('/getSymbolsTable', interpreter.getSymbolsTable)
// router.get('/getErrors', interpreter.getErrors)
// router.get('/getTokens', interpreter.getTokens)
export default router