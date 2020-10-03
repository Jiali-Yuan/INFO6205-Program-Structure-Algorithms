public String decodeString(String s) {
	Stack<Integer> num = new Stack<>();
	Stack<String> string = new Stack<>();
	StringBuilder cur = new StringBuilder();
	int len = s.length();
	for (int i = 0; i < len; i++) {
		char c = s.charAt(i);
		if (Character.isDigit(c)) {
			int n = c -'0';
			while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
				n = n * 10 + s.charAt(i + 1) - '0';
				i++;
			}
			num.push(n);
		}else if (c == '[') {
			string.push(cur.toString());
			cur = new StringBuilder();
		}else if (c == ']') {
			StringBuilder temp = new StringBuilder(string.pop());
			int repeat = num.pop();
			for (int j = 0; j < repeat; j++) {
				temp.append(cur);
			}
			cur = temp;
		}else {
			cur.append(c);
		}
	}
	return cur.toString();
}