
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Lenguaje;

import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Terminal.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\046\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\003\003\000\002\004\003\000\002\004\003" +
    "\000\002\004\003\000\002\006\007\000\002\007\004\000" +
    "\002\010\005\000\002\011\010\000\002\015\007\000\002" +
    "\016\005\000\002\017\012\000\002\020\005\000\002\021" +
    "\007\000\002\022\011\000\002\023\005\000\002\024\005" +
    "\000\002\025\005\000\002\026\005\000\002\027\006\000" +
    "\002\030\014\000\002\031\003\000\002\031\003\000\002" +
    "\031\003\000\002\031\003\000\002\031\003\000\002\032" +
    "\005\000\002\032\005\000\002\032\005\000\002\032\005" +
    "\000\002\032\005\000\002\033\005\000\002\033\005\000" +
    "\002\033\004\000\002\034\003\000\002\034\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\151\000\010\004\013\021\014\032\005\001\002\000" +
    "\012\002\ufffe\004\ufffe\021\ufffe\032\ufffe\001\002\000\004" +
    "\053\137\001\002\000\004\002\136\001\002\000\012\002" +
    "\ufffd\004\ufffd\021\ufffd\032\ufffd\001\002\000\012\002\ufffc" +
    "\004\ufffc\021\ufffc\032\ufffc\001\002\000\012\002\000\004" +
    "\013\021\014\032\005\001\002\000\012\002\ufffb\004\ufffb" +
    "\021\ufffb\032\ufffb\001\002\000\004\037\116\001\002\000" +
    "\004\037\015\001\002\000\004\053\016\001\002\000\004" +
    "\022\017\001\002\000\004\023\107\001\002\000\004\054" +
    "\106\001\002\000\004\024\023\001\002\000\004\025\055" +
    "\001\002\000\004\061\024\001\002\000\014\006\030\007" +
    "\027\040\025\041\026\052\033\001\002\000\030\025\uffe7" +
    "\042\uffe7\044\uffe7\045\uffe7\046\uffe7\047\uffe7\050\uffe7\051" +
    "\uffe7\054\uffe7\056\uffe7\062\uffe7\001\002\000\030\025\uffe6" +
    "\042\uffe6\044\uffe6\045\uffe6\046\uffe6\047\uffe6\050\uffe6\051" +
    "\uffe6\054\uffe6\056\uffe6\062\uffe6\001\002\000\032\010\uffdc" +
    "\025\uffdc\042\uffdc\044\uffdc\045\uffdc\046\uffdc\047\uffdc\050" +
    "\uffdc\051\uffdc\054\uffdc\056\uffdc\062\uffdc\001\002\000\032" +
    "\010\uffdd\025\uffdd\042\uffdd\044\uffdd\045\uffdd\046\uffdd\047" +
    "\uffdd\050\uffdd\051\uffdd\054\uffdd\056\uffdd\062\uffdd\001\002" +
    "\000\030\025\uffe9\042\uffe9\044\uffe9\045\uffe9\046\uffe9\047" +
    "\uffe9\050\uffe9\051\uffe9\054\uffe9\056\uffe9\062\uffe9\001\002" +
    "\000\030\025\uffe8\042\uffe8\044\uffe8\045\uffe8\046\uffe8\047" +
    "\uffe8\050\uffe8\051\uffe8\054\uffe8\056\uffe8\062\uffe8\001\002" +
    "\000\014\006\030\007\027\040\025\041\026\052\033\001" +
    "\002\000\030\025\uffea\042\uffea\044\uffea\045\uffea\046\uffea" +
    "\047\uffea\050\uffea\051\uffea\054\uffea\056\uffea\062\uffea\001" +
    "\002\000\022\025\ufff3\042\037\044\044\045\043\046\041" +
    "\047\040\050\042\051\036\001\002\000\014\006\030\007" +
    "\027\040\025\041\026\052\033\001\002\000\014\006\030" +
    "\007\027\040\025\041\026\052\033\001\002\000\014\006" +
    "\030\007\027\040\025\041\026\052\033\001\002\000\014" +
    "\006\030\007\027\040\025\041\026\052\033\001\002\000" +
    "\014\006\030\007\027\040\025\041\026\052\033\001\002" +
    "\000\014\006\030\007\027\040\025\041\026\052\033\001" +
    "\002\000\014\006\030\007\027\040\025\041\026\052\033" +
    "\001\002\000\030\025\uffe2\042\uffe2\044\uffe2\045\043\046" +
    "\041\047\040\050\042\051\036\054\uffe2\056\uffe2\062\uffe2" +
    "\001\002\000\030\025\uffe1\042\uffe1\044\uffe1\045\uffe1\046" +
    "\041\047\040\050\042\051\036\054\uffe1\056\uffe1\062\uffe1" +
    "\001\002\000\030\025\uffdf\042\uffdf\044\uffdf\045\uffdf\046" +
    "\uffdf\047\uffdf\050\uffdf\051\uffdf\054\uffdf\056\uffdf\062\uffdf" +
    "\001\002\000\030\025\uffe3\042\uffe3\044\uffe3\045\uffe3\046" +
    "\uffe3\047\uffe3\050\042\051\036\054\uffe3\056\uffe3\062\uffe3" +
    "\001\002\000\030\025\uffe4\042\uffe4\044\uffe4\045\uffe4\046" +
    "\041\047\uffe4\050\042\051\036\054\uffe4\056\uffe4\062\uffe4" +
    "\001\002\000\030\025\uffe5\042\uffe5\044\044\045\043\046" +
    "\041\047\040\050\042\051\036\054\uffe5\056\uffe5\062\uffe5" +
    "\001\002\000\030\025\uffe0\042\uffe0\044\uffe0\045\uffe0\046" +
    "\uffe0\047\uffe0\050\042\051\uffe0\054\uffe0\056\uffe0\062\uffe0" +
    "\001\002\000\030\025\uffde\042\uffde\044\uffde\045\uffde\046" +
    "\uffde\047\uffde\050\uffde\051\uffde\054\uffde\056\uffde\062\uffde" +
    "\001\002\000\004\061\057\001\002\000\004\054\ufff5\001" +
    "\002\000\004\053\060\001\002\000\004\026\063\001\002" +
    "\000\004\054\105\001\002\000\004\062\066\001\002\000" +
    "\004\061\064\001\002\000\014\006\030\007\027\040\025" +
    "\041\026\052\033\001\002\000\022\042\037\044\044\045" +
    "\043\046\041\047\040\050\042\051\036\062\ufff0\001\002" +
    "\000\004\027\067\001\002\000\004\061\103\001\002\000" +
    "\004\062\071\001\002\000\004\030\072\001\002\000\004" +
    "\061\101\001\002\000\004\062\074\001\002\000\004\031" +
    "\075\001\002\000\004\061\077\001\002\000\004\054\ufff1" +
    "\001\002\000\014\006\030\007\027\040\025\041\026\052" +
    "\033\001\002\000\022\042\037\044\044\045\043\046\041" +
    "\047\040\050\042\051\036\054\uffed\001\002\000\014\006" +
    "\030\007\027\040\025\041\026\052\033\001\002\000\022" +
    "\042\037\044\044\045\043\046\041\047\040\050\042\051" +
    "\036\062\uffee\001\002\000\014\006\030\007\027\040\025" +
    "\041\026\052\033\001\002\000\022\042\037\044\044\045" +
    "\043\046\041\047\040\050\042\051\036\062\uffef\001\002" +
    "\000\004\054\ufff2\001\002\000\012\002\ufff6\004\ufff6\021" +
    "\ufff6\032\ufff6\001\002\000\004\061\110\001\002\000\004" +
    "\055\111\001\002\000\004\037\112\001\002\000\004\062" +
    "\113\001\002\000\004\037\114\001\002\000\004\056\115" +
    "\001\002\000\004\024\ufff4\001\002\000\004\053\117\001" +
    "\002\000\004\005\122\001\002\000\004\010\127\001\002" +
    "\000\004\054\125\001\002\000\004\061\123\001\002\000" +
    "\006\006\030\007\027\001\002\000\004\010\ufff8\001\002" +
    "\000\012\002\ufffa\004\ufffa\021\ufffa\032\ufffa\001\002\000" +
    "\004\054\ufff9\001\002\000\004\061\130\001\002\000\004" +
    "\055\131\001\002\000\004\013\132\001\002\000\014\006" +
    "\030\007\027\040\025\041\026\052\033\001\002\000\022" +
    "\042\037\044\044\045\043\046\041\047\040\050\042\051" +
    "\036\056\134\001\002\000\004\054\ufff7\001\002\000\012" +
    "\002\uffff\004\uffff\021\uffff\032\uffff\001\002\000\004\002" +
    "\001\001\002\000\004\033\140\001\002\000\004\055\143" +
    "\001\002\000\004\054\142\001\002\000\012\002\uffec\004" +
    "\uffec\021\uffec\032\uffec\001\002\000\004\037\144\001\002" +
    "\000\004\056\145\001\002\000\004\034\146\001\002\000" +
    "\004\053\147\001\002\000\004\035\150\001\002\000\004" +
    "\061\151\001\002\000\014\006\030\007\027\040\025\041" +
    "\026\052\033\001\002\000\022\042\037\044\044\045\043" +
    "\046\041\047\040\050\042\051\036\054\153\001\002\000" +
    "\004\054\uffeb\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\151\000\016\002\005\003\010\004\003\006\006\015" +
    "\007\027\011\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\012\004\134\006\006\015\007\027\011\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\016\017\017\020\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\020\021\001\001\000\004\021" +
    "\055\001\001\000\002\001\001\000\012\031\034\032\033" +
    "\033\030\034\031\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\012\031\053\032\033\033\030\034" +
    "\031\001\001\000\002\001\001\000\002\001\001\000\012" +
    "\031\052\032\033\033\030\034\031\001\001\000\012\031" +
    "\051\032\033\033\030\034\031\001\001\000\012\031\050" +
    "\032\033\033\030\034\031\001\001\000\012\031\047\032" +
    "\033\033\030\034\031\001\001\000\012\031\046\032\033" +
    "\033\030\034\031\001\001\000\012\031\045\032\033\033" +
    "\030\034\031\001\001\000\012\031\044\032\033\033\030" +
    "\034\031\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\006\022\060" +
    "\023\061\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\012\031\064\032\033\033\030\034\031" +
    "\001\001\000\002\001\001\000\004\024\067\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\025\072\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\026\075\001" +
    "\001\000\002\001\001\000\002\001\001\000\012\031\077" +
    "\032\033\033\030\034\031\001\001\000\002\001\001\000" +
    "\012\031\101\032\033\033\030\034\031\001\001\000\002" +
    "\001\001\000\012\031\103\032\033\033\030\034\031\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\007\120\010\117\001" +
    "\001\000\004\011\125\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\034\123\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\031\132\032\033\033" +
    "\030\034\031\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\030\140\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\012" +
    "\031\151\032\033\033\030\034\031\001\001\000\002\001" +
    "\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    // Codigo Java


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= INSTRUCCIONES 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INSTRUCCIONES ::= INSTRUCCIONES INSTRUCCION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // INSTRUCCIONES ::= INSTRUCCION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // INSTRUCCION ::= ESTRATEGIA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // INSTRUCCION ::= PARTIDA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // INSTRUCCION ::= PUNTO_ACCESO 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ESTRATEGIA ::= RW_strategy TK_id TK_llaveA INSTRUCCIONES_ESTRATEGIA TK_llaveC 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ESTRATEGIA",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // INSTRUCCIONES_ESTRATEGIA ::= DECISION_INICIAL REGLAS 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES_ESTRATEGIA",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // DECISION_INICIAL ::= RW_initial TK_dosPuntos DECISION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("DECISION_INICIAL",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // REGLAS ::= RW_rules TK_dosPuntos TK_corcheteA RW_else EXPRESION TK_corcheteC 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("REGLAS",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // PARTIDA ::= RW_match TK_id TK_llaveA INSTRUCIONES_PARTIDA TK_llaveC 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("PARTIDA",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // INSTRUCIONES_PARTIDA ::= JUGADORES RONDAS PUNTUACIONES 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCIONES_PARTIDA",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // JUGADORES ::= RW_players RW_strategies TK_dosPuntos TK_corcheteA TK_id TK_coma TK_id TK_corcheteC 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("JUGADORES",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-7)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // RONDAS ::= RW_rounds TK_dosPuntos EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("RONDAS",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // PUNTUACIONES ::= RW_scoring TK_dosPuntos TK_llaveA PUNTOS TK_llaveC 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("PUNTUACIONES",15, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // PUNTOS ::= COOPERACION_MUTUA TK_coma DEFECCION_MUTUA TK_coma TRAIDOR TK_coma TRAICIONADO 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("PUNTOS",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // COOPERACION_MUTUA ::= RW_cooperacionM TK_dosPuntos EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COOPERACION_MUTUA",17, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // DEFECCION_MUTUA ::= RW_defeccionnM TK_dosPuntos EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("DEFECCION_MUTUA",18, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // TRAIDOR ::= RW_traidor TK_dosPuntos EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("TRAIDOR",19, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // TRAICIONADO ::= RW_traicionado TK_dosPuntos EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("TRAICIONADO",20, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // PUNTO_ACCESO ::= RW_main TK_llaveA INSTRUCCIONES_ACCESO TK_llaveC 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("PUNTO_ACCESO",21, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // INSTRUCCIONES_ACCESO ::= RW_run TK_corcheteA TK_id TK_corcheteC RW_with TK_llaveA RW_seed TK_dosPuntos EXPRESION TK_llaveC 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES_ACCESO",22, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-9)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // EXPRESION ::= RELACIONALES 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",23, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // EXPRESION ::= LOGICAS 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",23, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // EXPRESION ::= DECISION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",23, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // EXPRESION ::= TK_enteros 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",23, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // EXPRESION ::= TK_decimales 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",23, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // RELACIONALES ::= EXPRESION TK_igual EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("RELACIONALES",24, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // RELACIONALES ::= EXPRESION TK_mayorIgual EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("RELACIONALES",24, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // RELACIONALES ::= EXPRESION TK_menorIgual EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("RELACIONALES",24, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // RELACIONALES ::= EXPRESION TK_mayor EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("RELACIONALES",24, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // RELACIONALES ::= EXPRESION TK_menor EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("RELACIONALES",24, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // LOGICAS ::= EXPRESION TK_and EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("LOGICAS",25, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // LOGICAS ::= EXPRESION TK_or EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("LOGICAS",25, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // LOGICAS ::= TK_not EXPRESION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("LOGICAS",25, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // DECISION ::= RW_C 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("DECISION",26, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // DECISION ::= RW_D 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("DECISION",26, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
