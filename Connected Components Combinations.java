import java.util.*;
class node{
    int data;
    Vector<node> s;
    node(int data){
        this.data=data;
        s=new Vector<node>();
    }
} 
public class Test 
{
static final int M=1000000007;
 public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int q=sc.nextInt();
    int c=sc.nextInt();
        Vector<node> ve=new Vector<node>();
     for(int i=1;i<=n;i++){
         ve.add(new node(i));
     }
     int u,v;
    for(int i=1;i<=q;i++){
        u=sc.nextInt();
        v=sc.nextInt();
        ve.get(u-1).s.add(ve.get(v-1));
        ve.get(v-1).s.add(ve.get(u-1));
     }
    long ans=1;
    boolean[] b=new boolean[n+1];
    for(int i=1;i<=n;i++){
       
        if(!b[i]){
            long count=0;
            Stack<node> st=new Stack<node>();
            st.add(ve.get(i-1));
            b[i]=true;
            count++;
            while(!st.isEmpty()){
                node no=st.pop();
                int s=no.s.size();
               
                for(int j=0;j<s;j++){
                   
                    if(b[no.s.get(j).data]==false){
                    st.add(no.s.get(j));
                    b[no.s.get(j).data]=true;
                    count++;
                    }
                }
            }
            ans=((ans%M)*(count%M))%M;
        }
    }
 System.out.println(ans);
}
}
