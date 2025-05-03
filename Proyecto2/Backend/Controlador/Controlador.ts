import { Request,  Response } from "express";
// import { Env } from "../Classes/Env/Env";
// import { symTable } from '../Classes/Env/SymbolTable';
import { getSalida,  limpiarSalidas,  getErrores } from '../Clases/Utilidades/Salida';
import { Entorno } from "../Clases/Entorno/Entorno";
import { tablaSimbolos } from "../Clases/Entorno/Tabla";
// import { AST,  ReturnAST } from "../Classes/Env/AST";
// import { TypeInst } from "../Classes/Utils/TypeInst";

export class Controlador {

    public running(req: Request, res: Response) {
        res.send('Interpreter is running!!!')
    }
    public parserFile(req: Request, res: Response) {
        let file = req.body.file
        let parser = require('../Lenguaje/Parser')
        var fs = require('fs')
        console.log('\x1Bc');
        console.log(file)
        fs.readFile(file, 'utf-8', (err: Error, data: string) => {
            if(err) {
                console.log(err)
                res.json({
                    console: err
                })
            }
            else {
                limpiarSalidas()
                tablaSimbolos.splice()
                let instrucciones = parser.parse(data)
                const global: Entorno = new Entorno(null, 'Global')
                for(let instruccion of instrucciones) {
                    try {
                        instruccion.ejecutar(global)
                    }
                    catch (error) {}
                }
                var out: string = getSalida()
                console.log()
                console.log()
                console.log('\x1b[32mSimpleCode\x1b[0m')
                console.log(out)
                res.json({
                    console: out
                })
            }
        })
    }
    // public parser(req: Request, res: Response) {
    //     let code = req.body.code
    //     let parser = require('../Language/Parser')
    //     try {
    //         resetOuts()
    //         symTable.splice()
    //         let instructions = parser.parse(code)
    //         let ast: AST = new AST()
    //         const global: Env = new Env(null, 'Global')
    //         var dotAST: string =  'digraph G{\nnode[color="white" fontcolor="white"];\nedge[dir=none color="white"];\nbgcolor = "#0D1117";'
    //         dotAST += '\nnode_r[label="INSTRUCTIONS"];'
    //         var resultAST: ReturnAST
    //         for(let instruction of instructions) {
    //             try {
    //                 if(instruction.typeInst === TypeInst.INIT_FUNCTION) {
    //                     instruction.execute(global)
    //                     resultAST = instruction.ast(ast)
    //                     dotAST += '\n' + resultAST.dot
    //                     dotAST += `\nnode_r -> node_${resultAST.id};`
    //                 }
    //             }
    //             catch (error) {}
    //         }
    //         for(let instruction of instructions) {
    //             try {
    //                 if(instruction.typeInst !== TypeInst.INIT_FUNCTION) {
    //                     instruction.execute(global)
    //                     resultAST = instruction.ast(ast)
    //                     dotAST += '\n' + resultAST.dot
    //                     dotAST += `\nnode_r -> node_${resultAST.id};`
    //                 }
    //             }
    //             catch (error) {}
    //         }
    //         dotAST += '\n}'
    //         res_dotAST = dotAST
    //         res.json({
    //             console: getStringOuts()
    //         })
    //     }
    //     catch (error) {
    //         res.json({
    //             console: error
    //         })
    //     }
    // }
    // public getAST(req: Request, res: Response) {
    //     try {
    //         res.json({
    //             ast: res_dotAST
    //         })
    //     }
    //     catch (error) {
    //         res.json({
    //             ast: error
    //         })
    //     }
    // }
    public getSymbolsTable(req: Request, res: Response) {
        try {
            res.json({
                table: tablaSimbolos.simbolos
            })
        }
        catch (error) {
            res.json({
                table: error
            })
        }
    }
    public getErrores(req: Request, res: Response) {
        try {
            res.json({
                errors: getErrores()
            })
        }
        catch (error) {
            res.json({
                errors: error
            })
        }
    }
    // public getTokens(req: Request, res: Response) {
    //     try {
    //         res.json({
    //             tok: getTokens()
    //         })
    //     }
    //     catch (error) {
    //         res.json({
    //             tok: error
    //         })
    //     }
    // }
}