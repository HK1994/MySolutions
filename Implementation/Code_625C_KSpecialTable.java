import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_625C_KSpecialTable{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _625C_ solver=new _625C_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _625C_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), k=in.nextInt()-1;
            int[][] matrix=new int[n][n];
            int number=1;
            for(int col=0;col<k;++col)
                for(int row=0;row<n;matrix[row++][col]=number++) ;
            for(int row=0;row<n;++row)
                for(int col=k;col<n;matrix[row][col++]=number++) ;
            int sum=0;
            for(int row=0;row<n;sum+=matrix[row++][k]) ;
            out.println(sum);
            out.print(matrix);
        }

    }

    static class OutputWriter{
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream){
            writer=new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer){
            this.writer=new PrintWriter(writer);
        }

        public void print(int[] array){
            for(int i=0;i<array.length;i++){
                if(i!=0){
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void print(int[][] matrix){
            for(int i=0;i<matrix.length;++i){
                println(matrix[i]);
            }
        }

        public void println(int[] array){
            print(array);
            writer.println();
        }

        public void close(){
            writer.close();
        }

        public void println(int i){
            writer.println(i);
        }

    }

    static class InputReader{
        private InputStream stream;
        private byte[] buf=new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream){
            this.stream=stream;
        }

        public int read(){
            if(numChars==-1){
                throw new InputMismatchException();
            }
            if(curChar>=numChars){
                curChar=0;
                try{
                    numChars=stream.read(buf);
                }catch(IOException e){
                    throw new InputMismatchException();
                }
                if(numChars<=0){
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt(){
            int c=read();
            while(isSpaceChar(c)){
                c=read();
            }
            int sgn=1;
            if(c=='-'){
                sgn=-1;
                c=read();
            }
            int res=0;
            do{
                if(c<'0'||c>'9'){
                    throw new InputMismatchException();
                }
                res*=10;
                res+=c-'0';
                c=read();
            }while(!isSpaceChar(c));
            return res*sgn;
        }

        public boolean isSpaceChar(int c){
            if(filter!=null){
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c){
            return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
        }

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

