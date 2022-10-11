package excelwrite;
import jxl.*; 
import jxl.write.*; 
import jxl.write.Number; 
import java.io.*; 
import java.util.Locale; 
public class Excelwriter {
	public static void main(String[] args) throws IOException,WriteException {
		
		int r=0,c=0;
		String header[]={"Student Name","Subject1","Subject2","Subject3","Total"};
		String
		sname[]={"Carls","James","Paul","Philip","Smith","Thomson","Rhodey","Stark","Gary"
		,"AnneMarie"};
		int marks[]={50,45,60,55,70,45,67,78,89,90,30};
		File file = new File("student.xls");
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));
		WritableWorkbook workbook = Workbook.createWorkbook(file,
		wbSettings);
		workbook.createSheet("Report", 0);
		WritableSheet excelSheet = workbook.getSheet(0);
		
		for(r=0;r<1;r++) {
		for(c=0;c<header.length;c++) {
		Label l=new Label(c,r,header[c]);
		excelSheet.addCell(l);
		}
		}
		
		for(r=1;r<=sname.length;r++) {
		for(c=0;c<1;c++) {
		Label l=new Label(c,r,sname[r-1]);
		excelSheet.addCell(l);
		}
		}
		
		for(r=1;r<=sname.length;r++) {
		for(c=1;c<4;c++) {
		Number num = new Number(c, r, marks[r-1]);
		excelSheet.addCell(num);
		}
		}
		
		for(r=1;r<=sname.length;r++) {
		for(c=4;c<5;c++) {
		int total=marks[r-1]+marks[r-1]+marks[r-1];
		Number num = new Number(c, r, total);
		excelSheet.addCell(num);
		}
		}
		workbook.write();
		workbook.close();
		System.out.println("Excel File Created!!!!!");
		}
}
