public String removeKdigits(String num, int k) {
	if(k == 0) {
		return num;
	}
	if(num.length() == k) {
		return "0";
	}
	StringBuilder sb = new StringBuilder();
	for(char ch : num.toCharArray()){
		while(k > 0 && sb.length() != 0 && ch < sb.charAt(sb.length() - 1)){
			k -= 1;
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append((ch == '0' && sb.length() == 0) ? "" : ch);
	}
	while(k > 0){
		k -= 1;
		sb.deleteCharAt(sb.length() - 1);
	}
	return (sb.length() == 0) ? "0" : sb.toString();
}
