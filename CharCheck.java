import java.util.regex.Pattern;
import java.io.UnsupportedEncodingException;

class CharCheck {
	public static void main(String[] args) {
		String inp = "JGB 6209F239044455800000A19D44600002501300419300419TPN01  VB442550835GB    14                                 OX183UQ9ZGB SP61PA   SP61PA";
		String inp2 = "JGB 6209F239019100900000965E58C00016501080419080419TPN01  FQ513680305GB    B109，BROOK STUDIOS，536 BRISTOL RD  B296GB 9ZGB GU124RH  GU124RH";
		System.out.println(IsValidISO(inp2));
	}
	private static boolean IsValidISO(String s)
	{
		byte[] bytes;
		String s2 = "";
		try {
		bytes = s.getBytes("ISO-8859-1");
		s2 = new String(bytes, "ISO-8859-1");
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s2.equals(s);
	}
}
