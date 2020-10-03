public String simplifyPath(String path) {
	if(path.isEmpty()) return "";
	String[] str = path.split("\\/+");
	StringBuilder ans = new StringBuilder();
	Stack<String> st = new Stack<>();
	for(int i = 0; i < str.length; i++) {
		if(str[i].equals("..")) {
			if(!st.isEmpty())
			st.pop();
		}
		else if(str[i].equals(".")) {
			continue;
		} else {
			st.push(str[i]);
		}
	}
	while (!st.isEmpty()) {
		if (!st.peek().isEmpty())
		ans.insert(0, "/" + st.peek());
		st.pop();
	}
	return ans.length() == 0 ? "/" : ans.toString();
}

