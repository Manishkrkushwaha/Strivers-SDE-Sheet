npractice/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    
    public int key;
    public Node left;
    public Node right;
    
    Node(int key) {
        this.key = key;
    }
}

class Distance {
    public int val;
    Distance(int d) {
        val = d;
    }
}

class Codechef
{   //Inorder traversal - left -> root -> right
    public static void inorder(Node root) { 
        if(root != null) {
            inorder(root.left);
            System.out.println(root.key + " ");
            inorder(root.right);
        }
    }
    
    // Preorder traversal - root -> left -> right
    public static void preorder(Node root) {
        if(root != null) {
            System.out.println(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    //Post order trversal - left -> right -> root
    public static void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            println(root.key + " ");
        }
    }
    
    public static void height(Node root) {
        if(root == null)
            return 0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }
    
    public static void kDistance(root,k) {
        if(root == null)
            return;
        if(k == 0)
            System.out.println(root.key);
        else {
            kDistance(root.left,k-1);
            kDistance(root.right,k-1);
        }
    }
    
    public static void printLevel(Node root) {
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(q.isEmpty() == false) {
            Node curr = q.poll();
            // System.out.println(curr.key + " ");
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }
    }
    
    public static void printLevelOrderLine(Node root) {
        if(root == null)
            return;
        Queue q = new LinkedList<Queue>();
        q.ad(root);
        while(q.isEmpty() == false) {
            int count = q.size();
            for(int i = 0 ; i < count ; i++) {
                Node curr = q.poll();
                System.out.print(curr.key + " ");
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null)  q.add(curr.right);
            }
            System.out.println();
        }
    }
    
    public static int getSize(Node root) {
        if(root == null)
            return 0;
        else
            return 1+getSize(root.left)+getSize(root.right);
    }
    
    public static int getMaximum(Node root) {
        if(root == null)
            return Integer.MIN_VALUE;
        else
            return Math.max(root.key,Math.max(getMaximum(root.left),getMaximum(root.right)));
    }
    
    // public static void printLeft(Node root) {
    //     if(root == null)
    //         return;
    //     Queue<Node> q = new LinkedList<Node>();
    //     q.add(root);
    //     while(q.isEmpty() == false) {
    //         int count = q.size();
            
    //         for(int i = 0 ; i < count; i++) {
    //             Node curr = q.poll();
    //             if(i == 0) System.out.println(curr.key);
    //             if(curr.left != null) q.add(curr.left);
    //             if(curr.right != null) q.add(curr.right);
    //         }
    //     }
    // }
    
    int maxLevel = 0; // initially during function call level = 1
    public static void printLeft(Node right, int level) {
        if(root == null)
            return;
        if(maxLevel < level) {
            System.out.println(root.key);
            maxLevel = level;
        }
        printLeft(root.left,level+1);
        printLeft(root.righ,level+1);
    }
        
    public static boolean childrenSum(Node root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        int sum = 0;
        if(root.left != null) sum += root.left.key;
        if(root.right != null) sum += root.right.key;
        
        return (root.key == sum && childrenSum(root.left) && childrenSum(root.right));
    }
    
    // public static boolean isBalanced(Node root) {
    //     if(root == null)
    //         return true;
    //     int lh = height(root.left);
    //     int rh = height(root.right);
        
    //     return (Math.abs(lh-rh) <= 1 && isBalanced(root.left) && isBalanced(root.right));
    // }
    
    public static int isBalanced(Node root) {
        if(root == null) return 0;
        int lh = isBalanced(root.left);
        if(lh == -1) return -1;
        int rh = isBalanced(root.right);
        if(rh == -1) return -1;
        if(Math.abs(lh-rh) > 1) return -1;
        else return Math.max(lh,rh)+1;
    }
    
    Node prev = null;
    public static Node BTtoDLL(Node root) {
        if(root == null)
            return root;
        Node head = BTtoDLL(root.left);
        if(prev == null)
            head = root;
        else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        BTtoDLL(root.right);
        return head;
    }
    
    // public static void printSpiral(Node root) {
    //     if(root == null)
    //         return;
    //     Queue<Node> q = new LinkedList<Node>();
    //     q.add(root);
    //     Stack<Integer> s = new Stack<Integer>();
    //     boolean reverse = false;
    //     while(q.isEmpty() == false) {
    //         int count = q.size();
    //         for(int i = 0 ; i < count ; i++) {
    //             Node curr = q.poll();
    //             if(reverse)
    //                 s.push(curr.key);
    //             else
    //                 System.out.print(curr.key + " ");
    //             if(curr.left != null) q.add(curr.left);
    //             if(curr.right != null) q.add(curr.right);
    //         }
    //         if(reverse)
    //             while(s.isEmpty() == false)
    //                 System.out.print(s.pop() + " ");
    //         reverse = !reverse;
    //         System.out.println();
    //     }
    // }
    
    public static void printSpiral(Node root) {
        if(root == null)
            return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        
        s1.push(root);
        
        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                Node curr = s1.pop();
                System.out.print(curr.key + " ");
                if(curr.left != null) s2.push(curr.left);
                if(curr.right != null) s2.push(curr.right);
            }
            while(s2.isEmpty() == false) {
                Node curr = s2.pop();
                System.out.print(curr.key + " ");
                if(curr.right != null) s1.add(curr.right);
                if(curr.left != null) s1.add(curr.left);
            }
        }
    }
    
    // public static int diameter(Node root) {
    //     if(root == null)
    //         return 0;
        
    //     int d1 = 1 + height(root.left) + height(root.right);
        
    //     int d2 = diameter(root.left);
    //     int d3 = diameter(root.right);
        
    //     return Math.max(d1,Math.max(d2,d3));
    // }
    
    int res = 0;
    public static int diameter(Node root) {
        if(root == null)
            return 0;
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        
        int res = Math.max(res,1+lh+rh);
        
        return 1 + Math.max(lh,rh);
    }
    
    // public static boolean findPath(Node root, ArrayList<Node> p, int n) {
    //     if(root == null)
    //         return false;
    //     p.add(root);
    //     if(findPath(root.left,p,n) || findPath(root.right,p,n)) 
    //         return true;
            
    //     p.remove(p.size()-1);
    //     return false;
    // }
    // public static Node lca(Node root, int n1, int n2) {
    //     if(root == null)
    //         return null;
    //     ArrayList<Node> path1 = new ArrayList<Node>();
    //     ArrayList<Node> path2 = new ArrayList<Node>();
        
    //     if(findPath(root,path1,n1)==false || findPath(root,path2,n2)==false)
    //         return null;
        
    //     for(int i = 0; i<path1.size()-1 && i<path2.size()-1 ; i++) {
    //         if(path1[i+1] != path2[i+1])
    //             return path[i];
    //     }
    //     return false;
    // }
    
    public static Node lca(Node root, int n1, int n2) {
        if(root == null)
            return null;
        if(root.key == n1 || root.key == n2)
            return root;
        
        Node lca1 = lca(root.left,n1,n2);
        Node lca2 = lca(root.right,n1,n2);
        
        if(lac1 != null && lac2 != null)
            return root;
        if(lca1 != null)
            return lca1;
        else
            return lca2;
    }
    
    int res = 0;
    public static int burnTime(Node root, int leaf, Distance dist) {
        if(root == null)
            return 0;
        if(root.key == leaf) {
            dist.val = 0;
            return 1;
        }
        
        Distance ldist = new Distance(-1);
        Distance rdist = new Distance(-1);
        
        int lh = burnTime(root.left, leaf, ldist);
        int rh = burnTime(root.right, leaf, rdist);
        
        if(ldist.val != -1) {
            dist.val = ldist.val+1;
            res = Math.max(res,rh + dist.val)
        }
        else if(rdist.val != -1) {
            dist.val = ldist.val + 1;
            res = Math.max(res, lh+dist.val);
        }
        
        return 1 + Math.max(lh,rh);
    }
    
    public static int countNodes(Node root) {
        int lh = 0, rh = 0;
        Node curr = root;
        while(curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while(curr != null) {
            rh++;
            curr = curr.right;
        }
        
        if(lh == rh) {
            return Math.pow(2,lh)-1;
        else
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
    
    public static void serialize(Node root, ArrayList<Integer> arr) {
        if(root == null) {
            arr.add(-1);
            return;
        }
        
        arr.add(root.key);
        serialize(root.left);
        serialize(root.right);
    }
    
    int index = 0;
    public static Node deSerialize(ArrayList<Integer> arr) {
        if(index == arr.size()) 
            return null;
        int val = arr[index];
        index++;
        if(val == -1)
            return null;
        Node root = new Node(val);
        root.left = deSerialize(arr);
        root.right = deSerialize(arr);
        
        return root;
    }
    
    public static void iterativeInorder(Node root) {
        if(root == null)
            return;
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while(s.isEmpty() == false || root != null) {
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }
    public static void iterativePreorder(Node root) {
        if(root == null)
            return;
        Stack<Node> s = new Stack<Node>();
        Node curr = root;
        
        while(curr != null || s.isEmpty() == false) {
            while(curr != null) {
                System.out.print(curr.key + " ");
                if(curr.right != null)
                    s.push(curr.right);
                curr = curr.left;
            }
            if(s.isEmpty() == false)
                curr = s.pop();
        }
    }
    
    // public static void iterativePreorder(Node root) {
    //     if(root == null)
    //         return;
    //     Stack<Node> s = new Stack<>();
    //     s.push(root);
        
    //     while(s.isEmpty() == false) {
    //         Node curr = s.pop();
            
    //         System.out.print(curr.key + " ");
            
    //         if(curr.right != null) s.push(curr.right);
    //         if(curr.left != null) s.push(curr.left);
    //     }
    // }
    
	public static void process() throws IOException {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
	}

	//=============================================================================
	//--------------------------The End---------------------------------
	//=============================================================================
	private static long INF = 2000000000000000000L, M = 1000000007, MM = 998244353;
	private static int N = 0;

	private static void google(int tt) {
		System.out.print("Case #" + (tt) + ": ");
	}

	static FastScanner sc;
	static FastWriter out;

	public static void main(String[] args) throws IOException {
		boolean oj = true;
		if (oj) {
			sc = new FastScanner();
			out = new FastWriter(System.out);
		} else {
			sc = new FastScanner("input.txt");
			out = new FastWriter("output.txt");
		}
		long s = System.currentTimeMillis();
		int t = 1;
		t = sc.nextInt();
		int TTT = 1;
		while (t-- > 0) {
			//			google(TTT++);
			process();
		}
		out.flush();
		//		tr(System.currentTimeMillis()-s+"ms");
	}

	private static boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	private static void tr(Object... o) {
		if (!oj)
			System.err.println(Arrays.deepToString(o));
	}

	static class Pair implements Comparable<Pair> {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.x, o.x);
		}

		/*
		 	@Override
		    public boolean equals(Object o) {
		        if (this == o) return true;
		        if (!(o instanceof Pair)) return false;
		        Pair key = (Pair) o;
		        return x == key.x && y == key.y;
		    }
		 
		    @Override
		    public int hashCode() {
		        int result = x;
		        result = 31 * result + y;
		        return result;
		    }
		*/
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	static int ceil(int x, int y) {
		return (x % y == 0 ? x / y : (x / y + 1));
	}

	static long ceil(long x, long y) {
		return (x % y == 0 ? x / y : (x / y + 1));
	}

	static long sqrt(long z) {
		long sqz = (long) Math.sqrt(z);
		while (sqz * 1L * sqz < z) {
			sqz++;
		}
		while (sqz * 1L * sqz > z) {
			sqz--;
		}
		return sqz;
	}

	static int log2(int N) {
		int result = (int) (Math.log(N) / Math.log(2));
		return result;
	}

	public static long gcd(long a, long b) {
		if (a > b)
			a = (a + b) - (b = a);
		if (a == 0L)
			return b;
		return gcd(b % a, a);
	}

	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

	public static int lower_bound(int[] arr, int x) {
		int low = 0, high = arr.length - 1, mid = -1;
		int ans = -1;
		while (low <= high) {
			mid = (low + high) / 2;

			if (arr[mid] > x) {
				high = mid - 1;
			} else {
				ans = mid;
				low = mid + 1;
			}
		}

		return ans;
	}

	public static int upper_bound(int[] arr, int x) {
		int low = 0, high = arr.length - 1, mid = -1;
		int ans = arr.length;
		while (low < high) {
			mid = (low + high) / 2;

			if (arr[mid] >= x) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return ans;
	}

	static void ruffleSort(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
		Arrays.sort(a);
	}

	static void ruffleSort(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
		Arrays.sort(a);
	}

	static void reverseArray(int[] a) {
		int n = a.length;
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = a[n - i - 1];
		for (int i = 0; i < n; i++)
			a[i] = arr[i];
	}

	static void reverseArray(long[] a) {
		int n = a.length;
		long arr[] = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = a[n - i - 1];
		for (int i = 0; i < n; i++)
			a[i] = arr[i];
	}

	//custom multiset (replace with HashMap if needed)
	public static void push(TreeMap<Integer, Integer> map, int k, int v) {
		//map[k] += v;
		if (!map.containsKey(k))
			map.put(k, v);
		else
			map.put(k, map.get(k) + v);
	}

	public static void pull(TreeMap<Integer, Integer> map, int k, int v) {
		//assumes map[k] >= v
		//map[k] -= v
		int lol = map.get(k);
		if (lol == v)
			map.remove(k);
		else
			map.put(k, lol - v);
	}

	// compress Big value to Time Limit
	public static int[] compress(int[] arr) {
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for (int x : arr)
			ls.add(x);
		Collections.sort(ls);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int boof = 1; //min value
		for (int x : ls)
			if (!map.containsKey(x))
				map.put(x, boof++);
		int[] brr = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			brr[i] = map.get(arr[i]);
		return brr;
	}

	// Fast Writer 

	public static class FastWriter {
		private static final int BUF_SIZE = 1 << 13;
		private final byte[] buf = new byte[BUF_SIZE];
		private final OutputStream out;
		private int ptr = 0;

		private FastWriter() {
			out = null;
		}

		public FastWriter(OutputStream os) {
			this.out = os;
		}

		public FastWriter(String path) {
			try {
				this.out = new FileOutputStream(path);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("FastWriter");
			}
		}

		public FastWriter write(byte b) {
			buf[ptr++] = b;
			if (ptr == BUF_SIZE)
				innerflush();
			return this;
		}

		public FastWriter write(char c) {
			return write((byte) c);
		}

		public FastWriter write(char[] s) {
			for (char c : s) {
				buf[ptr++] = (byte) c;
				if (ptr == BUF_SIZE)
					innerflush();
			}
			return this;
		}

		public FastWriter write(String s) {
			s.chars().forEach(c -> {
				buf[ptr++] = (byte) c;
				if (ptr == BUF_SIZE)
					innerflush();
			});
			return this;
		}

		private static int countDigits(int l) {
			if (l >= 1000000000)
				return 10;
			if (l >= 100000000)
				return 9;
			if (l >= 10000000)
				return 8;
			if (l >= 1000000)
				return 7;
			if (l >= 100000)
				return 6;
			if (l >= 10000)
				return 5;
			if (l >= 1000)
				return 4;
			if (l >= 100)
				return 3;
			if (l >= 10)
				return 2;
			return 1;
		}

		public FastWriter write(int x) {
			if (x == Integer.MIN_VALUE) {
				return write((long) x);
			}
			if (ptr + 12 >= BUF_SIZE)
				innerflush();
			if (x < 0) {
				write((byte) '-');
				x = -x;
			}
			int d = countDigits(x);
			for (int i = ptr + d - 1; i >= ptr; i--) {
				buf[i] = (byte) ('0' + x % 10);
				x /= 10;
			}
			ptr += d;
			return this;
		}

		private static int countDigits(long l) {
			if (l >= 1000000000000000000L)
				return 19;
			if (l >= 100000000000000000L)
				return 18;
			if (l >= 10000000000000000L)
				return 17;
			if (l >= 1000000000000000L)
				return 16;
			if (l >= 100000000000000L)
				return 15;
			if (l >= 10000000000000L)
				return 14;
			if (l >= 1000000000000L)
				return 13;
			if (l >= 100000000000L)
				return 12;
			if (l >= 10000000000L)
				return 11;
			if (l >= 1000000000L)
				return 10;
			if (l >= 100000000L)
				return 9;
			if (l >= 10000000L)
				return 8;
			if (l >= 1000000L)
				return 7;
			if (l >= 100000L)
				return 6;
			if (l >= 10000L)
				return 5;
			if (l >= 1000L)
				return 4;
			if (l >= 100L)
				return 3;
			if (l >= 10L)
				return 2;
			return 1;
		}

		public FastWriter write(long x) {
			if (x == Long.MIN_VALUE) {
				return write("" + x);
			}
			if (ptr + 21 >= BUF_SIZE)
				innerflush();
			if (x < 0) {
				write((byte) '-');
				x = -x;
			}
			int d = countDigits(x);
			for (int i = ptr + d - 1; i >= ptr; i--) {
				buf[i] = (byte) ('0' + x % 10);
				x /= 10;
			}
			ptr += d;
			return this;
		}

		public FastWriter write(double x, int precision) {
			if (x < 0) {
				write('-');
				x = -x;
			}
			x += Math.pow(10, -precision) / 2;
			//		if(x < 0){ x = 0; }
			write((long) x).write(".");
			x -= (long) x;
			for (int i = 0; i < precision; i++) {
				x *= 10;
				write((char) ('0' + (int) x));
				x -= (int) x;
			}
			return this;
		}

		public FastWriter writeln(char c) {
			return write(c).writeln();
		}

		public FastWriter writeln(int x) {
			return write(x).writeln();
		}

		public FastWriter writeln(long x) {
			return write(x).writeln();
		}

		public FastWriter writeln(double x, int precision) {
			return write(x, precision).writeln();
		}

		public FastWriter write(int... xs) {
			boolean first = true;
			for (int x : xs) {
				if (!first)
					write(' ');
				first = false;
				write(x);
			}
			return this;
		}

		public FastWriter write(long... xs) {
			boolean first = true;
			for (long x : xs) {
				if (!first)
					write(' ');
				first = false;
				write(x);
			}
			return this;
		}

		public FastWriter writeln() {
			return write((byte) '\n');
		}

		public FastWriter writeln(int... xs) {
			return write(xs).writeln();
		}

		public FastWriter writeln(long... xs) {
			return write(xs).writeln();
		}

		public FastWriter writeln(char[] line) {
			return write(line).writeln();
		}

		public FastWriter writeln(char[]... map) {
			for (char[] line : map)
				write(line).writeln();
			return this;
		}

		public FastWriter writeln(String s) {
			return write(s).writeln();
		}

		private void innerflush() {
			try {
				out.write(buf, 0, ptr);
				ptr = 0;
			} catch (IOException e) {
				throw new RuntimeException("innerflush");
			}
		}

		public void flush() {
			innerflush();
			try {
				out.flush();
			} catch (IOException e) {
				throw new RuntimeException("flush");
			}
		}

		public FastWriter print(byte b) {
			return write(b);
		}

		public FastWriter print(char c) {
			return write(c);
		}

		public FastWriter print(char[] s) {
			return write(s);
		}

		public FastWriter print(String s) {
			return write(s);
		}

		public FastWriter print(int x) {
			return write(x);
		}

		public FastWriter print(long x) {
			return write(x);
		}

		public FastWriter print(double x, int precision) {
			return write(x, precision);
		}

		public FastWriter println(char c) {
			return writeln(c);
		}

		public FastWriter println(int x) {
			return writeln(x);
		}

		public FastWriter println(long x) {
			return writeln(x);
		}

		public FastWriter println(double x, int precision) {
			return writeln(x, precision);
		}

		public FastWriter print(int... xs) {
			return write(xs);
		}

		public FastWriter print(long... xs) {
			return write(xs);
		}

		public FastWriter println(int... xs) {
			return writeln(xs);
		}

		public FastWriter println(long... xs) {
			return writeln(xs);
		}

		public FastWriter println(char[] line) {
			return writeln(line);
		}

		public FastWriter println(char[]... map) {
			return writeln(map);
		}

		public FastWriter println(String s) {
			return writeln(s);
		}

		public FastWriter println() {
			return writeln();
		}
	}

	// Fast Inputs
	static class FastScanner {
		//I don't understand how this works lmao
		private int BS = 1 << 16;
		private char NC = (char) 0;
		private byte[] buf = new byte[BS];
		private int bId = 0, size = 0;
		private char c = NC;
		private double cnt = 1;
		private BufferedInputStream in;

		public FastScanner() {
			in = new BufferedInputStream(System.in, BS);
		}

		public FastScanner(String s) {
			try {
				in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
			} catch (Exception e) {
				in = new BufferedInputStream(System.in, BS);
			}
		}

		private char getChar() {
			while (bId == size) {
				try {
					size = in.read(buf);
				} catch (Exception e) {
					return NC;
				}
				if (size == -1)
					return NC;
				bId = 0;
			}
			return (char) buf[bId++];
		}

		public int nextInt() {
			return (int) nextLong();
		}

		public int[] readArray(int N) {
			int[] res = new int[N];
			for (int i = 0; i < N; i++) {
				res[i] = (int) nextLong();
			}
			return res;
		}

		public long[] readArrayLong(int N) {
			long[] res = new long[N];
			for (int i = 0; i < N; i++) {
				res[i] = nextLong();
			}
			return res;
		}

		public int[][] readArrayMatrix(int N, int M, int Index) {
			if (Index == 0) {
				int[][] res = new int[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++)
						res[i][j] = (int) nextLong();
				}
				return res;
			}
			int[][] res = new int[N][M];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++)
					res[i][j] = (int) nextLong();
			}
			return res;

		}

		public long[][] readArrayMatrixLong(int N, int M, int Index) {
			if (Index == 0) {
				long[][] res = new long[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++)
						res[i][j] = nextLong();
				}
				return res;
			}
			long[][] res = new long[N][M];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++)
					res[i][j] = nextLong();
			}
			return res;

		}

		public long nextLong() {
			cnt = 1;
			boolean neg = false;
			if (c == NC)
				c = getChar();
			for (; (c < '0' || c > '9'); c = getChar()) {
				if (c == '-')
					neg = true;
			}
			long res = 0;
			for (; c >= '0' && c <= '9'; c = getChar()) {
				res = (res << 3) + (res << 1) + c - '0';
				cnt *= 10;
			}
			return neg ? -res : res;
		}

		public double nextDouble() {
			double cur = nextLong();
			return c != '.' ? cur : cur + nextLong() / cnt;
		}

		public double[] readArrayDouble(int N) {
			double[] res = new double[N];
			for (int i = 0; i < N; i++) {
				res[i] = nextDouble();
			}
			return res;
		}

		public String next() {
			StringBuilder res = new StringBuilder();
			while (c <= 32)
				c = getChar();
			while (c > 32) {
				res.append(c);
				c = getChar();
			}
			return res.toString();
		}

		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while (c <= 32)
				c = getChar();
			while (c != '\n') {
				res.append(c);
				c = getChar();
			}
			return res.toString();
		}

		public boolean hasNext() {
			if (c > 32)
				return true;
			while (true) {
				c = getChar();
				if (c == NC)
					return false;
				else if (c > 32)
					return true;
			}
		}
	}
}
