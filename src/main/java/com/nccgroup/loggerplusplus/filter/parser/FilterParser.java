/* FilterParser.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. FilterParser.java */
package com.nccgroup.loggerplusplus.filter.parser;
import com.nccgroup.loggerplusplus.filter.Operator;
import com.nccgroup.loggerplusplus.filter.BooleanOperator;
import com.nccgroup.loggerplusplus.filterlibrary.FilterLibraryController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.HashSet;
import java.math.BigDecimal;

public class FilterParser/*@bgen(jjtree)*/implements FilterParserTreeConstants, FilterParserConstants {/*@bgen(jjtree)*/
  protected JJTFilterParserState jjtree = new JJTFilterParserState();
    public static ASTExpression parseFilter(String string) throws IOException, ParseException {
        FilterParser FilterParser = new FilterParser(new StringReader(string));
        ASTExpression node;
        try{
            node = FilterParser.Filter();
        }catch(Exception e){
            throw new ParseException(e.getMessage());
        }
        VisitorData result = new SanityCheckVisitor().visit(node);
        if(!result.isSuccess()) throw new ParseException(result.getErrorString());
        return node;
    }

    public static void checkAliasesForSanity(FilterLibraryController libraryController, ASTExpression filter) throws ParseException {
        VisitorData result = new AliasCheckVisitor(libraryController).visit(filter);
        if(!result.isSuccess()) throw new ParseException(result.getErrorString());
    }

  final public ASTExpression Filter() throws ParseException {/*@bgen(jjtree) Expression */
 ASTExpression jjtn000 = new ASTExpression(JJTEXPRESSION);
 boolean jjtc000 = true;
 jjtree.openNodeScope(jjtn000);Boolean inverse=false;
 BooleanOperator op = null;
    try {
      ExpressionInner();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OR:
      case AND:
      case XOR:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case AND:{
          label_1:
          while (true) {
            op = And();
            ExpressionInner();
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case AND:{
              ;
              break;
              }
            default:
              jj_la1[0] = jj_gen;
              break label_1;
            }
          }
          break;
          }
        case OR:{
          label_2:
          while (true) {
            op = Or();
            ExpressionInner();
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case OR:{
              ;
              break;
              }
            default:
              jj_la1[1] = jj_gen;
              break label_2;
            }
          }
          break;
          }
        case XOR:{
          label_3:
          while (true) {
            op = Xor();
            ExpressionInner();
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case XOR:{
              ;
              break;
              }
            default:
              jj_la1[2] = jj_gen;
              break label_3;
            }
          }
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        ;
      }
      jj_consume_token(0);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
jjtn000.op = op;
        jjtn000.inverse = inverse;
        {if ("" != null) return jjtn000;}
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
}

  final public ASTExpression Expression() throws ParseException {/*@bgen(jjtree) Expression */
 ASTExpression jjtn000 = new ASTExpression(JJTEXPRESSION);
 boolean jjtc000 = true;
 jjtree.openNodeScope(jjtn000);Boolean inverse = null;
 BooleanOperator op = null;
    try {
      if (jj_2_1(2)) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case INVERSE:{
          inverse = Inverse();
          break;
          }
        default:
          jj_la1[5] = jj_gen;
          ;
        }
        jj_consume_token(LPAREN);
        ExpressionInner();
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case OR:
        case AND:
        case XOR:{
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case AND:{
            label_4:
            while (true) {
              op = And();
              ExpressionInner();
              switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
              case AND:{
                ;
                break;
                }
              default:
                jj_la1[6] = jj_gen;
                break label_4;
              }
            }
            break;
            }
          case OR:{
            label_5:
            while (true) {
              op = Or();
              ExpressionInner();
              switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
              case OR:{
                ;
                break;
                }
              default:
                jj_la1[7] = jj_gen;
                break label_5;
              }
            }
            break;
            }
          case XOR:{
            label_6:
            while (true) {
              op = Xor();
              ExpressionInner();
              switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
              case XOR:{
                ;
                break;
                }
              default:
                jj_la1[8] = jj_gen;
                break label_6;
              }
            }
            break;
            }
          default:
            jj_la1[9] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          break;
          }
        default:
          jj_la1[10] = jj_gen;
          ;
        }
        jj_consume_token(RPAREN);
      } else {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case BOOLEAN:
        case SINGLEQUOTEDSTRING:
        case DOUBLEQUOTEDSTRING:
        case NUMBER:
        case REGEXLITERAL:
        case REGEX:
        case INVERSE:
        case IDENTIFIER:{
          Comparison();
          break;
          }
        default:
          jj_la1[11] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
jjtn000.op = op;
        jjtn000.inverse = inverse != null;
        {if ("" != null) return jjtn000;}
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
}

  final public void ExpressionInner() throws ParseException {
    if (jj_2_2(3)) {
      Comparison();
    } else {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ALIAS_SYMBOL:{
        Alias();
        break;
        }
      case BOOLEAN:
      case SINGLEQUOTEDSTRING:
      case DOUBLEQUOTEDSTRING:
      case NUMBER:
      case REGEXLITERAL:
      case REGEX:
      case LPAREN:
      case INVERSE:
      case IDENTIFIER:{
        Expression();
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
}

//Comparisons can take two forms (Value) or (value operation value).
//To make interpretation easier, we convert (Value) to (Value operation value) by means of (Value EQUALS TRUE)
  final public ASTComparison Comparison() throws ParseException {/*@bgen(jjtree) Comparison */
 ASTComparison jjtn000 = new ASTComparison(JJTCOMPARISON);
 boolean jjtc000 = true;
 jjtree.openNodeScope(jjtn000);Operator op;
 Object left, right;
 Boolean value;
    try {
      left = Value();
jjtn000.left = left;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case EQ:
      case NEQ:
      case GT:
      case LT:
      case GEQ:
      case LEQ:
      case CONTAINS:{
        op = Operator();
        right = Value();
jjtn000.right = right;
            jjtn000.operator = op;
        break;
        }
      case IN:{
        op = InOperator();
        right = Array();
jjtn000.right = right;
            jjtn000.operator = op;
        break;
        }
      default:
        jj_la1[13] = jj_gen;
jjtn000.operator = Operator.EQUAL;
            jjtn000.right = true;
      }
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
{if ("" != null) return jjtn000;}
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
}

  final public ASTAlias Alias() throws ParseException {/*@bgen(jjtree) Alias */
    ASTAlias jjtn000 = new ASTAlias(JJTALIAS);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);Token identifier;
    try {
      jj_consume_token(ALIAS_SYMBOL);
      identifier = jj_consume_token(IDENTIFIER);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
jjtn000.identifier = identifier.image;
        {if ("" != null) return jjtn000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
}

  final public Object Value() throws ParseException {Object v;
    if (jj_2_3(2)) {
      v = Identifier();
    } else {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case NUMBER:{
        v = Number();
        break;
        }
      case BOOLEAN:
      case INVERSE:{
        v = Boolean();
        break;
        }
      case SINGLEQUOTEDSTRING:
      case DOUBLEQUOTEDSTRING:{
        v = String();
        break;
        }
      case REGEXLITERAL:
      case REGEX:{
        v = Regex();
        break;
        }
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
{if ("" != null) return v;}
    throw new Error("Missing return statement in function");
}

  final public HashSet Array() throws ParseException {HashSet<Object> items = new HashSet();
    Object i;
    jj_consume_token(ARRAY_START);
    if (jj_2_4(2)) {
      i = String();
items.add(i);
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case ARRAY_SEPARATOR:{
          ;
          break;
          }
        default:
          jj_la1[15] = jj_gen;
          break label_7;
        }
        jj_consume_token(ARRAY_SEPARATOR);
        i = String();
items.add(i);
      }
    } else if (jj_2_5(2)) {
      i = Number();
items.add(i);
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case ARRAY_SEPARATOR:{
          ;
          break;
          }
        default:
          jj_la1[16] = jj_gen;
          break label_8;
        }
        jj_consume_token(ARRAY_SEPARATOR);
        i = Number();
items.add(i);
      }
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(ARRAY_END);
{if ("" != null) return items;}
    throw new Error("Missing return statement in function");
}

//IDENTIFIERS
  final public ASTIdentifier Identifier() throws ParseException {/*@bgen(jjtree) Identifier */
    ASTIdentifier jjtn000 = new ASTIdentifier(JJTIDENTIFIER);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);Token group, identifier, inverse = null;
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INVERSE:{
        inverse = jj_consume_token(INVERSE);
        break;
        }
      default:
        jj_la1[17] = jj_gen;
        ;
      }
      group = jj_consume_token(IDENTIFIER);
      jj_consume_token(DOT);
      identifier = jj_consume_token(IDENTIFIER);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
jjtn000.inverse = inverse != null;
        jjtn000.group = group.image;
        jjtn000.field = identifier.image;
        {if ("" != null) return jjtn000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
}

//END IDENTIFIERS


//TYPES
  final public 
BigDecimal Number() throws ParseException {Token t;
    t = jj_consume_token(NUMBER);
{if ("" != null) return new BigDecimal(t.image);}
    throw new Error("Missing return statement in function");
}

  final public String String() throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case SINGLEQUOTEDSTRING:{
      t = jj_consume_token(SINGLEQUOTEDSTRING);
      break;
      }
    case DOUBLEQUOTEDSTRING:{
      t = jj_consume_token(DOUBLEQUOTEDSTRING);
      break;
      }
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
String s = t.image.substring(1,t.image.length()-1);
        {if ("" != null) return org.apache.commons.text.StringEscapeUtils.unescapeJava(s);}
    throw new Error("Missing return statement in function");
}

  final public Pattern Regex() throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case REGEXLITERAL:{
      t = jj_consume_token(REGEXLITERAL);
      break;
      }
    case REGEX:{
      t = jj_consume_token(REGEX);
      break;
      }
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return Pattern.compile(t.image.substring(1,t.image.length()-1), Pattern.CASE_INSENSITIVE);}
    throw new Error("Missing return statement in function");
}

  final public Boolean Boolean() throws ParseException {Token t, inverse=null;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case INVERSE:{
      inverse = jj_consume_token(INVERSE);
      break;
      }
    default:
      jj_la1[20] = jj_gen;
      ;
    }
    t = jj_consume_token(BOOLEAN);
{if ("" != null) return (inverse != null ^ Boolean.parseBoolean(t.image));}
    throw new Error("Missing return statement in function");
}

//END TYPES


//BASIC OPERATORS
  final public 
Operator Operator() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case EQ:{
      jj_consume_token(EQ);
{if ("" != null) return Operator.EQUAL;}
      break;
      }
    case NEQ:{
      jj_consume_token(NEQ);
{if ("" != null) return Operator.NOT_EQUAL;}
      break;
      }
    case GT:{
      jj_consume_token(GT);
{if ("" != null) return Operator.GREATER_THAN;}
      break;
      }
    case LT:{
      jj_consume_token(LT);
{if ("" != null) return Operator.LESS_THAN;}
      break;
      }
    case GEQ:{
      jj_consume_token(GEQ);
{if ("" != null) return Operator.GREATER_THAN_EQUAL;}
      break;
      }
    case LEQ:{
      jj_consume_token(LEQ);
{if ("" != null) return Operator.LESS_THAN_EQUAL;}
      break;
      }
    case CONTAINS:{
      jj_consume_token(CONTAINS);
{if ("" != null) return Operator.CONTAINS;}
      break;
      }
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public Operator InOperator() throws ParseException {
    jj_consume_token(IN);
{if ("" != null) return Operator.IN;}
    throw new Error("Missing return statement in function");
}

  final public boolean Inverse() throws ParseException {
    jj_consume_token(INVERSE);
{if ("" != null) return true;}
    throw new Error("Missing return statement in function");
}

  final public BooleanOperator And() throws ParseException {
    jj_consume_token(AND);
{if ("" != null) return BooleanOperator.AND;}
    throw new Error("Missing return statement in function");
}

  final public BooleanOperator Or() throws ParseException {
    jj_consume_token(OR);
{if ("" != null) return BooleanOperator.OR;}
    throw new Error("Missing return statement in function");
}

  final public BooleanOperator Xor() throws ParseException {
    jj_consume_token(XOR);
{if ("" != null) return BooleanOperator.XOR;}
    throw new Error("Missing return statement in function");
}

  private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_1()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_2()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_3()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_4()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_5()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_3R_32()
 {
    if (jj_scan_token(ARRAY_START)) return true;
    return false;
  }

  private boolean jj_3R_17()
 {
    if (jj_scan_token(INVERSE)) return true;
    return false;
  }

  private boolean jj_3R_31()
 {
    if (jj_scan_token(IN)) return true;
    return false;
  }

  private boolean jj_3_3()
 {
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_20()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_3()) {
    jj_scanpos = xsp;
    if (jj_3R_26()) {
    jj_scanpos = xsp;
    if (jj_3R_27()) {
    jj_scanpos = xsp;
    if (jj_3R_28()) {
    jj_scanpos = xsp;
    if (jj_3R_29()) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_42()
 {
    if (jj_scan_token(CONTAINS)) return true;
    return false;
  }

  private boolean jj_3R_41()
 {
    if (jj_scan_token(LEQ)) return true;
    return false;
  }

  private boolean jj_3R_40()
 {
    if (jj_scan_token(GEQ)) return true;
    return false;
  }

  private boolean jj_3R_39()
 {
    if (jj_scan_token(LT)) return true;
    return false;
  }

  private boolean jj_3R_38()
 {
    if (jj_scan_token(GT)) return true;
    return false;
  }

  private boolean jj_3R_37()
 {
    if (jj_scan_token(NEQ)) return true;
    return false;
  }

  private boolean jj_3R_30()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_36()) {
    jj_scanpos = xsp;
    if (jj_3R_37()) {
    jj_scanpos = xsp;
    if (jj_3R_38()) {
    jj_scanpos = xsp;
    if (jj_3R_39()) {
    jj_scanpos = xsp;
    if (jj_3R_40()) {
    jj_scanpos = xsp;
    if (jj_3R_41()) {
    jj_scanpos = xsp;
    if (jj_3R_42()) return true;
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_36()
 {
    if (jj_scan_token(EQ)) return true;
    return false;
  }

  private boolean jj_3R_24()
 {
    if (jj_scan_token(ALIAS_SYMBOL)) return true;
    return false;
  }

  private boolean jj_3R_19()
 {
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_29()
 {
    if (jj_3R_35()) return true;
    return false;
  }

  private boolean jj_3R_23()
 {
    return false;
  }

  private boolean jj_3R_18()
 {
    if (jj_3R_24()) return true;
    return false;
  }

  private boolean jj_3R_34()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(22)) jj_scanpos = xsp;
    if (jj_scan_token(BOOLEAN)) return true;
    return false;
  }

  private boolean jj_3R_22()
 {
    if (jj_3R_31()) return true;
    if (jj_3R_32()) return true;
    return false;
  }

  private boolean jj_3R_28()
 {
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_35()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(18)) {
    jj_scanpos = xsp;
    if (jj_scan_token(19)) return true;
    }
    return false;
  }

  private boolean jj_3R_21()
 {
    if (jj_3R_30()) return true;
    if (jj_3R_20()) return true;
    return false;
  }

  private boolean jj_3R_16()
 {
    if (jj_scan_token(ARRAY_SEPARATOR)) return true;
    return false;
  }

  private boolean jj_3R_14()
 {
    if (jj_scan_token(ARRAY_SEPARATOR)) return true;
    return false;
  }

  private boolean jj_3R_11()
 {
    if (jj_3R_20()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_21()) {
    jj_scanpos = xsp;
    if (jj_3R_22()) {
    jj_scanpos = xsp;
    if (jj_3R_23()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_13()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(14)) {
    jj_scanpos = xsp;
    if (jj_scan_token(15)) return true;
    }
    return false;
  }

  private boolean jj_3R_27()
 {
    if (jj_3R_34()) return true;
    return false;
  }

  private boolean jj_3R_9()
 {
    if (jj_3R_17()) return true;
    return false;
  }

  private boolean jj_3R_15()
 {
    if (jj_scan_token(NUMBER)) return true;
    return false;
  }

  private boolean jj_3_2()
 {
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3R_10()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) {
    jj_scanpos = xsp;
    if (jj_3R_19()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_26()
 {
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3R_33()
 {
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3_1()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_9()) jj_scanpos = xsp;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_10()) return true;
    return false;
  }

  private boolean jj_3R_25()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_1()) {
    jj_scanpos = xsp;
    if (jj_3R_33()) return true;
    }
    return false;
  }

  private boolean jj_3R_12()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(22)) jj_scanpos = xsp;
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(DOT)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3_5()
 {
    if (jj_3R_15()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_16()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3_4()
 {
    if (jj_3R_13()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_14()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  /** Generated Token Manager. */
  public FilterParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[22];
  static private int[] jj_la1_0;
  static {
	   jj_la1_init_0();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x200,0x100,0x400,0x700,0x700,0x400000,0x200,0x100,0x400,0x700,0x700,0x14de000,0x115de000,0x18fc,0x4de000,0x8000000,0x8000000,0x400000,0xc000,0xc0000,0x400000,0x8fc,};
	}
  final private JJCalls[] jj_2_rtns = new JJCalls[5];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public FilterParser(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public FilterParser(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new FilterParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 22; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 22; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public FilterParser(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new FilterParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 22; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new FilterParserTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 22; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public FilterParser(FilterParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 22; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(FilterParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 22; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   if (++jj_gc > 100) {
		 jj_gc = 0;
		 for (int i = 0; i < jj_2_rtns.length; i++) {
		   JJCalls c = jj_2_rtns[i];
		   while (c != null) {
			 if (c.gen < jj_gen) c.first = null;
			 c = c.next;
		   }
		 }
	   }
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
	 if (jj_scanpos == jj_lastpos) {
	   jj_la--;
	   if (jj_scanpos.next == null) {
		 jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
	   } else {
		 jj_lastpos = jj_scanpos = jj_scanpos.next;
	   }
	 } else {
	   jj_scanpos = jj_scanpos.next;
	 }
	 if (jj_rescan) {
	   int i = 0; Token tok = token;
	   while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
	   if (tok != null) jj_add_error_token(kind, i);
	 }
	 if (jj_scanpos.kind != kind) return true;
	 if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
	 return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
	 if (pos >= 100) {
		return;
	 }

	 if (pos == jj_endpos + 1) {
	   jj_lasttokens[jj_endpos++] = kind;
	 } else if (jj_endpos != 0) {
	   jj_expentry = new int[jj_endpos];

	   for (int i = 0; i < jj_endpos; i++) {
		 jj_expentry[i] = jj_lasttokens[i];
	   }

	   for (int[] oldentry : jj_expentries) {
		 if (oldentry.length == jj_expentry.length) {
		   boolean isMatched = true;

		   for (int i = 0; i < jj_expentry.length; i++) {
			 if (oldentry[i] != jj_expentry[i]) {
			   isMatched = false;
			   break;
			 }

		   }
		   if (isMatched) {
			 jj_expentries.add(jj_expentry);
			 break;
		   }
		 }
	   }

	   if (pos != 0) {
		 jj_lasttokens[(jj_endpos = pos) - 1] = kind;
	   }
	 }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[29];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 22; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 29; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 jj_endpos = 0;
	 jj_rescan_token();
	 jj_add_error_token(0, 0);
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private int trace_indent = 0;
  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
	 jj_rescan = true;
	 for (int i = 0; i < 5; i++) {
	   try {
		 JJCalls p = jj_2_rtns[i];

		 do {
		   if (p.gen > jj_gen) {
			 jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
			 switch (i) {
			   case 0: jj_3_1(); break;
			   case 1: jj_3_2(); break;
			   case 2: jj_3_3(); break;
			   case 3: jj_3_4(); break;
			   case 4: jj_3_5(); break;
			 }
		   }
		   p = p.next;
		 } while (p != null);

		 } catch(LookaheadSuccess ls) { }
	 }
	 jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
	 JJCalls p = jj_2_rtns[index];
	 while (p.gen > jj_gen) {
	   if (p.next == null) { p = p.next = new JJCalls(); break; }
	   p = p.next;
	 }

	 p.gen = jj_gen + xla - jj_la; 
	 p.first = token;
	 p.arg = xla;
  }

  static final class JJCalls {
	 int gen;
	 Token first;
	 int arg;
	 JJCalls next;
  }

}
