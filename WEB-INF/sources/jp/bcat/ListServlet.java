package jp.bcat;
import java.io.*;
import javax.servlet.http.*;

public class ListServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        BookCatalog catalog = BookCatalog.getInstance();
        Book result[] = catalog.getBooks();
        
        response.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>�}���ꗗ</TITLE></HEAD>");
        out.println("<BODY><P>" + result.length + "����</P>");
        BookWriter w = new BookWriter(out, " ");
        for(int i = 0; i < result.length; i++){
            out.println("<PRE>[" + (i+1) + "]:");
            out.println("�}��ID�F" + result[i].getBookId());
            w.write(result[i]);
            out.println("</PRE>");
        }
        out.println("<A href='./'>���j���[�ɖ߂�</A>");
        out.println("</BODY></HTML>");
    }
}