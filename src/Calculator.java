
public class Calculator {
	public int add(String input) {
		// TODO Auto-generated method stub
		if(input!=null&&!input.isEmpty()){
			int kq=0;
			if(input.contains("\n"))
				input=input.replaceAll("\n",",");
			System.out.println(""+input);
			if(input.contains("//")){
				String delimitter_list=input.substring(input.indexOf("["),input.lastIndexOf("]")+1);
				input=input.substring(input.indexOf(",")+1);
				System.out.println("delimiter list: "+delimitter_list);
				while (delimitter_list.contains("[")) {
					String delimiter=delimitter_list.substring(delimitter_list.indexOf("[")+1,delimitter_list.indexOf("]"));
					delimitter_list=delimitter_list.substring(delimitter_list.indexOf("]")+1);
					System.out.println("delimiter: "+delimiter);
					input=input.replaceAll(delimiter,",");
				}
				System.out.println("now: "+input);
			}
//				
			boolean flag_nagetives=false;
			String negatives_messendger="negatives not allowed: ";
			while (input.contains(",")) {
				String temp_number_toAdd=input.substring(0,input.indexOf(","));
//				System.out.println(temp_number_toAdd);
				int number_toAdd= Integer.parseInt(input.substring(0,input.indexOf(",")));
				input=input.substring(input.indexOf(",")+1);
				kq+=number_toAdd%1000;
				if(number_toAdd<0){
					if(flag_nagetives)
						negatives_messendger+=", "+number_toAdd;
					else 
						negatives_messendger+=number_toAdd;
					flag_nagetives=true;
//					continue;
				}
			}
			kq+= Integer.parseInt(input)%1000;
			
			if (flag_nagetives) {
				if(Integer.parseInt(input)<0)
				negatives_messendger+=", "+input;
				throw new RuntimeException(negatives_messendger);
			}
			
			return kq;
		}
		return 0;
	}
}
//////////////////////Game Over!