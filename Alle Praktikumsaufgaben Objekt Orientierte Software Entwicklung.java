Alle Praktikumsaufgaben - Objekt Orientierte Software Entwicklung
------------------------------------------------------------------
Exercise Sheet 1
-----------------------------------------------------------------------------------------------------------------------------------------

Date
class Date{
  int day;
  int month;
  int year;
  Date(int day,int month,int year){
    this.day = day;
    this.month = month;
    this.year = year;
  }
  public String toString(){
    return day+"."+month+"."+year;
  }
  public static void main(String[] args){
    Date datum = new Date(30,11,2018);
  }
}

Time
class Time{
  int second;
  int minute;
  int hour;
  Time(int h,int m,int s){
    second = s;
    minute = m;
    hour = h;
  }
  public String toString(){
  return hour+":"+minute+" Uhr";
  }
  public static void main(String[] args){
    Time zeit = new Time(12,59,15);
  }
}

DateTime
class DateTime{
  Date date;
  Time time;
  DateTime(Date d,Time t){
    date = d;
    time = t;
  }
  public String toString(){
    return "Datum: "+date+" Uhrzeit: "+time;
  }
  public static void main(String[] args){
    Date d = new Date(29,11,2018);
    Time t = new Time(12,59,15);
    DateTime dt = new DateTime(d,t);
  }
}

Appointment
class Appointment{
  DateTime time;
  int length;
  String reason;
  String place;
  Appointment(DateTime time,int length,String reason,String place){
    this.time = time;
    this.length = length;
    this.reason = reason;
    this.place = place;
  }
  public String toString(){
    return time+", Dauer des Termins:"+length+" Minuten"+", Grund:"+reason+", Ort:"+place;
  }
  public static void main(String[] args){
    Date d = new Date(29,11,2018);
    Time t = new Time(12,59,15);
    DateTime dt = new DateTime(d,t);
    Appointment ap = new Appointment(dt,60,"Zahnarzt","Burgstraﬂe 4");
  } 
}

-----------------------------------------------------------------------------------------------------------------------------------------
Exercise Sheet 2
-----------------------------------------------------------------------------------------------------------------------------------------

Date / earlier/later....
class Date{
  int day;
  int month;
  int year;
    
  Date(int d,int m,int y){
    day = d;
    month = m;
    year = y;
  }
  
  public String toString(){
    return day+"."+month+"."+year;
  }
  
  boolean isEarlierThan(Date that){
    if (this.year<that.year) return true;
    if (this.year>that.year) return false;
    if (this.month<that.month) return true;
    if (this.month>that.month) return false;
    if (this.day<that.day) return true;
    return false;
  }
  
  boolean isLaterThan(Date that){
    if (this.year>that.year) return true;
    if (this.year<that.year) return false;
    if (this.month>that.month) return true;
    if (this.month<that.month) return false;
    if (this.day>that.day) return true;
    return false;
  }
  
  boolean isSameDate(Date that){
    return this.day==that.day&&this.month==that.month
      &&this.year==that.year;
  }
  
  boolean isLeapYear(){
    if (year % 4 == 0 && (year % 100 !=0 || year % 400 == 0)) return true;
    return false;
  }
    
  int getAbsoluteDaysInYear(){
    if (year % 4 == 0 && (year % 100 !=0 || year % 400 == 0)) return 366;
    else return 365;
  }
}

Time earlier/later...
class Time{
  int second;
  int minute;
  int hour;
  Time(int h,int m,int s){
    second = s;
    minute = m;
    hour = h;
  }
  public String toString(){
    return hour+":"+minute+" Uhr";
  }
  boolean isEarlierThan(Time that){
    if(this.hour<that.hour) return true;
    if(this.hour>that.hour) return false;
    if(this.minute<that.minute) return true;
    if(this.minute>that.minute) return false;
    if(this.second<that.second) return true;
    return false;
  }
  boolean isLaterThan(Time that){
    if(this.hour>that.hour) return true;
    if(this.hour<that.hour) return false;
    if(this.minute>that.minute) return true;
    if(this.minute<that.minute) return false;
    if(this.second>that.second) return true;
    return false;
  }
  Time minutesLater(int min){
    minute = minute + min;
    while (minute > 59){
      minute = (60 - minute) * -1;
      hour = hour + 1;
    }
    while (hour > 23){
      hour = (24 - hour) * -1;
    }
    while (minute < 0){
      hour = hour - 1;
      minute = 60 + minute;
    }
    Time t1 = new Time(hour,minute,second);
    return t1;  
  }
}

DateTime earlier/later...
class DateTime{
  Date date;
  Time time;
  
  DateTime(Date d,Time t){
    date = d;
    time = t;
  }
  boolean isEarlierThan(DateTime that){
    if(this.date.year<that.date.year) return true;
    if(this.date.year>that.date.year) return false;
    if(this.date.month<that.date.month) return true;
    if(this.date.month>that.date.month) return false;
    if(this.date.day<that.date.day) return true;
     
    if(this.time.hour<that.time.hour) return true;
    if(this.time.hour>that.time.hour) return false;
    if(this.time.minute<that.time.minute) return true;
    if(this.time.minute>that.time.minute) return false;
    if(this.time.second<that.time.second) return true;
    if(this.time.second>that.time.second) return false;
    return false;
  }
  boolean isLaterThan(DateTime that){
    if(this.date.year>that.date.year) return true;
    if(this.date.year<that.date.year) return false;
    if(this.date.month>that.date.month) return true;
    if(this.date.month<that.date.month) return false;
    if(this.date.day>that.date.day) return true;
     
    if(this.time.hour>that.time.hour) return true;
    if(this.time.hour<that.time.hour) return false;
    if(this.time.minute>that.time.minute) return true;
    if(this.time.minute<that.time.minute) return false;
    if(this.time.second>that.time.second) return true;
    if(this.time.second<that.time.second) return false;
    return false;
  }
}

Appointment (endingTime)
class Appointment {
  DateTime time;
  int length;
  String reason;
  String place;
     
  Appointment(DateTime time,int length,String reason,String place){
    this.time = time;
    this.length = length;
    this.reason = reason;
    this.place = place;
  }
     
  public String toString(){
    return time.toString()+", Dauer des Termins:"+length+" Minuten"
      +", Grund: "+reason+", Ort:"+place;
  }
  public DateTime endingTime(){
    time.time.minute = time.time.minute + length;
    while (time.time.minute > 59){
      time.time.minute = (60 - time.time.minute) * -1;
      time.time.hour = time.time.hour + 1;
    }
    while (time.time.hour > 23){
      time.time.hour = (24 - time.time.hour) * -1;
      time.date.day = time.date.day + 1;
    }
    while (time.time.minute < 0){
      time.time.hour = time.time.hour - 1;
      time.time.minute = 60 + time.time.minute;
    }
    Time t1 = new Time(time.time.hour,time.time.minute,time.time.second);
    Date d1 = new Date(time.date.day,time.date.month,time.date.year);
    DateTime end = new DateTime(d1,t1);
    return end;
  }
   
  public static void main(String[] args) {
     
    Date d = new Date(29,11,2018);
    Time t = new Time(12,59,15);
    DateTime dt = new DateTime(d,t);
    Appointment ap = new Appointment(dt,60,"Zahnarzt","Burgstraﬂe 4");
    System.out.println(ap.toString());
  } 
}

-----------------------------------------------------------------------------------------------------------------------------------------
Exercise Sheet 3
-----------------------------------------------------------------------------------------------------------------------------------------

Date (assert)
class Date{
  int day;
  int month;
  int year;
 
  Date(int d,int m,int y){
    day = d;
    month = m;
    year = y;
    assert day < 31 && day > 0;
    assert month < 12 && month > 0;
  }
   
  public String toString(){
    return day+"."+month+"."+year;
  }
}

Fibonacci Rekursiv
class Fib{
  static int fib(int n) {
    if(n < 0) {
      return 0;
    }
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }
    else return fib(n-2)+fib(n-1);  
  }
}

Fibonacci-Generator
class Fib{
  long folge = 0;
  long summe = 1;
  long tmpsumme;
  int x = 0;
  long nextFib(){
    if (x == 0){
      x = x + 1;
      return 0;
    }
    while(x < 100){
      tmpsumme = summe + folge;
      folge = summe;
      summe = tmpsumme;
       
      return folge;
    }
    return 0;
  }
   
  public static void main(String[] args){
    Fib fib = new Fib();
    for (int i=0;i <= 10; i = i+1){
      System.out.println(fib.nextFib());
    }
  }
}

Fibonacci nicht rekursiv
class Fib{
  static long fib(int n) {
    double fibonacci;
    fibonacci = (Math.pow(((1 + Math.sqrt(5)) / 2),n) 
      - Math.pow(((1 - Math.sqrt(5)) / 2),n)) / Math.sqrt(5);
    return (long) fibonacci;
  }
}

Date (wochentag)
class Date{
  int day;
  int month;
  int year;
   
  Date(int day,int month,int year){
    this.day = day;
    this.month = month;
    this.year = year;
  }
  public String toString(){
    return day+"."+month+"."+year;
  }
  public static void main(String[] args){
    Date datum = new Date(30,11,2018);
  }
 
  int dayOfWeek(){
    int w;
    int c = 0;
    int y = 0;
    int month1 = 0;
    if (month == 1) month1 = 11;
    if (month == 2) month1 = 12;
    if (month > 2 && month < 13) month1 = month -2;
     
    if (month == 1 && year % 100 == 00) c = (year / 100) - 1;
    if (month == 2 && year % 100 == 00) c = (year / 100) - 1;
    if (month > 2 && month < 13) c = year / 100;    
     
    if (month == 1) y = (year % 100) - 1;
    if (month == 2) y = (year % 100) - 1;
    if (month == 1 && year % 100 == 00) y = 99;
    if (month == 2 && year % 100 == 00) y = 99;
    if (month > 2 && month < 13) y = year % 100;
     
    //So = 0, Mo = 1, Di = 2, Mi = 3, Do = 4, Fr = 5, Sa = 6
    w = (int) (day+(2.6*month1-0.2)+y+(y/4)+(c/4)-2*c)%7;
    return w;
  }
}

Date (Ostern)
class Date{
  int day;
  int month;
  int year;
   
  Date(int day,int month,int year){
    this.day = day;
    this.month = month;
    this.year = year;
  }
  public String toString(){
    return day+"."+month+"."+year;
  }
   
  Date easter(){
    int a = year % 19;
    int b = year / 100;
    int c = year % 100;
    int d = b / 4;
    int e = b % 4;
    int f = (b + 8) / 25;
    int g = (b - f + 1) / 3;
    int h = (19 * a + b - d - g + 15) % 30;
    int i = c / 4;
    int k = c % 4;
    int l = (32 + 2 * e + 2 * i - h - k) % 7;
    int m = (a + 11 * h + 22 * l) / 451;
    int n = (h + l - 7 * m + 114) / 31;
    int p = (h + l - 7 * m + 114) % 31;
    int p1 = p + 1;
    Date ostern = new Date(p1,n,year);
    return ostern;
  }
}

Zahlendarstellungen
class Num{
  //n is assumed to be a positive number
  final long n;
  Num(long n){
    assert n>=0;
    this.n = n;
  }
  String toBin(){
    String result = ((n%2==0)? "0":"1");
    if(n==0||n==1){
      return "0"+result;  
    }
    return new Num(n/2).toBin()+result;
  }
  String toOct(){
    String result = ((n%8==0)? "0":String.valueOf(n%8));
    if(n<8){
      return "0"+result;
    }
    return new Num(n/8).toOct()+result;
  }
  String toBase(int b){
    String result = ((n%b>9)? Character.toString(getDigit(n%b)):String.valueOf(n%b));
    if(n<b){
      return "0"+result;
    }
    return new Num(n/b).toBase(b)+result;
  }
  static char getDigit(long d){
    return (char) (d<10? '0'+d : 'A'+d-10);
  }  

-----------------------------------------------------------------------------------------------------------------------------------------
Exercise Sheet 4
-----------------------------------------------------------------------------------------------------------------------------------------

Date (Muttertag, Kalender)
class Date{
  int day;
  int month;
  int year;
  Date(int day,int month,int year){
    this.day = day;
    this.month = month;
    this.year = year;
  }
  int dayOfWeek(){
    int h;
    int k;
    if (this.month <= 2){
      h = this.month + 12;
      k = this.year - 1;
    }else{
      h = this.month;
      k = this.year;
    }
    return (this.day + 2*h + (3*h + 3) / 5 + k + k / 4 - k / 100
        + k / 400 +1) % 7;
  }
  Date nextDay(){
    day = day + 1;
    while ((month == 1 || month == 3 || month == 5 || month == 7
      || month == 8 || month == 10 || month == 12) && day > 31){
      day = day - 31;
      month = month + 1;
      if (month > 12){
        month = month - 12;
        year = year + 1;
      }
      return new Date(day,month,year);
    }
    while ((month == 4 || month == 6 || month == 9
      || month == 11) && day > 30){
      day = day - 30;
      month = month + 1;
      if (month > 12){
        month = month - 12;
        year = year + 1;
      }
      return new Date(day,month,year);
    }
    while ((month == 2 && (year % 4 == 0 && (year % 100 !=0
      || year % 400 == 0))) && day > 29){
      day = day - 29;
      month = month + 1;
      if (month > 12){
        month = month - 12;
        year = year + 1;
      }
      return new Date(day,month,year);
    }
    while (month == 2 && (year % 4 != 0 && (year % 100 ==0
      || year % 400 != 0)) && day > 28){
      day = day - 28;
      month = month + 1;
      if (month > 12){
        month = month - 12;
        year = year + 1;
      } 
      return new Date(day,month,year);
    }
    return new Date(day,month,year);
  }
  String monthAsHTML(){
    Date currentDay = new Date(1,this.month,this.year); 
    String date = "<table>"
        + "<tr><th>Mo</th><th>Di</th><th>Mi</th><th>Do"
        + "</th><th>Fr</th><th>Sb</th><th>So</th></tr>";
    for(int row = 0; row < 6; row = row + 1){
      if(currentDay.month == this.month){
        date = date + "<tr>";
        for(int cell = 0; cell < 7; cell = cell + 1){
          if(currentDay.month == this.month){
            date = date + "<td>";
            int realValue = 0;
            switch(cell){
              case 0: realValue = 1; break;
              case 1: realValue = 2; break;
              case 2: realValue = 3; break;
              case 3: realValue = 4; break;
              case 4: realValue = 5; break;
              case 5: realValue = 6; break;
              default: realValue = 0; break;
            }
            int dow = currentDay.dayOfWeek();
            if(dow == realValue){
              date = date + currentDay.day;
              currentDay = currentDay.nextDay();
            }
            date = date + "</td>";
          }  
        }
        date = date + "</tr>";
      }
    }
    date = date + "</table>";
    return date;
  }
  Date mothersDay(){
    int wd = new Date(1,5,this.year).dayOfWeek();
    return new Date(wd == 0 ? 8 : (15 - wd),5,this.year);
  }
}

GeometricObject
class GeometricObject {
  Vertex corner;
  double width;
  double height;
  Vertex velocity;
 
  GeometricObject(Vertex corner, double width, double height, Vertex velocity) {
    this.corner = corner;
    this.width = width;
    this.height = height;
    this.velocity = velocity;
  }
 
  double size(){
    return height * width;
  }
  boolean isLargerThan(GeometricObject that){
    return this.size()>that.size();
  }
  boolean isAbove(GeometricObject that){
    return this.corner.y + height < that.corner.y;
  }
  boolean isUnderneath(GeometricObject that){
    return this.corner.y > that.corner.y + height;
  }
  boolean isLeftOf(GeometricObject that){
    return this.corner.x + width < that.corner.x;
  }
  boolean isRightOf(GeometricObject that){
    return that.isLeftOf(this);
  }
  boolean touches(GeometricObject that){
    return !(isAbove(that) || isUnderneath(that) 
      || isLeftOf(that)||isRightOf(that));
  }
  @Override
  public String toString() {
    return "GeometricObject("+corner+", "+width+", "+height+", "+velocity+")";
  }
     
}

FunGraph
public final class FunGraph {
  private FunGraph(){}
   
  static String mkStringGraph(int xMin,int xMax,int yMin,int yMax){
    String result="";
 
    for(int y=yMax;y>=yMin;y--){
      for(int x=xMin;x<=xMax;x++){
        if(x*x<=y &&(x+1)*(x+1)>y||x*x<=y &&(x-1)*(x-1)>y){
          result = result + "*";
        }else if(x==0){
          result = result + "|";
        }else if(y==0){
          result = result + "-";
        }else{
          result = result + " ";
        }
      }
      result = result + "\n";
    }
 
    return result;
  }
  public static void main(String[] args) {
    System.out.println(mkStringGraph(-2,2,0,4));
    System.out.println(mkStringGraph(-4,4,0,16));
    System.out.println(mkStringGraph(-5,5,0,25));
  }
   
}

Date (Himmelfahrt)
class Date{
  int day;
  int month;
  int year;
  
  Date(int day, int month, int year){
    assert month>0;
    assert month<13;
    assert day>0;
    assert day<32;
  
    this.day = day;
    this.month = month;
    this.year = year;
  }
  public boolean equals(Date d){
    return (d.day == day) && (d.month == month);  
  }
  
  Date ascensionDay(){
    int a = year % 19;
    int b = year / 100;
    int c = year % 100;
    int d = b / 4;
    int e = b % 4;
    int f = (b + 8) / 25;
    int g = (b - f + 1) / 3;
    int h = (19 * a + b - d - g + 15) % 30;
    int i = c / 4;
    int k = c % 4;
    int l = (32 + 2 * e + 2 * i - h - k) % 7;
    int m = (a + 11 * h + 22 * l) / 451;
    //n = Der Monat
    int n = (h + l - 7 * m + 114) / 31;
    int p = (h + l - 7 * m + 114) % 31;
    //p1 = OsterSonntag
    int p1 = p + 1;
    //p2 = HimmelfahrtTag
    int p2 = p1 + 40;
 
    while (p2 > 31){
      p2 = p2 - 31;
      n = n + 1;
    }
    return new Date(p2,n,year);
  }
  static int howOftenTenthOfMay(int startYear, int endYear){
    int length = endYear - startYear;
    int result = 0;
    for(int i=0;i<=length;i++){
      Date x = new Date(1,1,startYear);
      Date y = new Date(10,5,2018);
      x.ascensionDay();
      if(x.ascensionDay().equals(y)){
        result = result + 1;
      }
      startYear = startYear + 1;
    }
    return result;
  }
}

-----------------------------------------------------------------------------------------------------------------------------------------
Exercise Sheet 5
-----------------------------------------------------------------------------------------------------------------------------------------

BigInteger Factorial:
import java.math.BigInteger;
public final class BigIntegerFactorial {
 
  private BigIntegerFactorial() {
  }
 
  static BigInteger factorial(long n){
    BigInteger result = BigInteger.ONE;
    while(n>1){
      result = BigInteger.valueOf(n).multiply(result);
      n = n - 1;
    }
    return result;
  }
}

ButtonLogic 1
class ToUpperLogic extends ButtonLogic {
 
  @Override
  String eval(String x) {
    return x.toUpperCase();
  }
  @Override
  String getButtonLabel() {
    return "To Upper Case";
  }
 
  public static void main(String[] args){
    new Dialogue(new ToUpperLogic());
    new ConsoleDialogue(new ToUpperLogic()).run();
  }
}

ButtonLogic 2
class StringLengthLogic extends ButtonLogic {
 
  @Override
  String eval(String x) {
    return String.valueOf(x.length());
  }
  @Override
  String getButtonLabel() {
    return "The Length Of This Text";
  }
 
  public static void main(String[] args){
    new Dialogue(new StringLengthLogic());
    new ConsoleDialogue(new StringLengthLogic()).run();
  }
}
ButtonLogic 3
class FactorialLogic extends ButtonLogic {
   
  @Override
  String eval(String x) {
    return String.valueOf(BigIntegerFactorial.factorial(Long.parseLong(x)));
  }
  @Override
  String getButtonLabel() {
    return "Die Fakult‰t";
  }
   
  public static void main(String[] args){
    new Dialogue(new FactorialLogic());
    new ConsoleDialogue(new FactorialLogic()).run();
  }
}

ButtonLogic 4
class EasterLogic extends ButtonLogic {
 
  @Override
  String eval(String x){
    int year = Integer.valueOf(x);
    Date d = new Date(1,1,year);
    return d.easter().toString();
  }
 
  @Override
  String getButtonLabel(){
    return "Das Datum des Ostersonntag";
  }
   
  public static void main(String[] args){
    //new Dialogue(new EasterLogic());
    new ConsoleDialogue(new EasterLogic()).run();
  }
}

ButtonLogic 5
class DayOfWeekLogic extends ButtonLogic {
 
  @Override
  String getButtonLabel(){
    return "Day Of Week";
  }
  @Override
  String eval(String x){ 
    String[] parts = x.split("\\."); 
 
    String day1 = parts[0];
    int day = Integer.valueOf(day1);
    String month1 = parts[1];
    int month = Integer.valueOf(month1);
    String year1 = parts[2];
    int year = Integer.valueOf(year1);
     
    Date d = new Date(day,month,year);
    int dayOfWeek = d.dayOfWeek();
    String nameOfDay;
    switch(dayOfWeek){
      case 0: nameOfDay = "Sonntag";break;
      case 1: nameOfDay = "Montag";break;
      case 2: nameOfDay = "Dienstag";break;
      case 3: nameOfDay = "Mittwoch";break;
      case 4: nameOfDay = "Donnerstag";break;
      case 5: nameOfDay = "Freitag";break;
      default: nameOfDay = "Samstag";break;
    }
    return nameOfDay;
  }  
  public static void main(String[] args){
    new Dialogue(new DayOfWeekLogic());
    new ConsoleDialogue(new DayOfWeekLogic()).run();
  }
}

Ellipse
class Ellipse extends GeometricObject {
 
  static Vertex v = new Vertex(0,0);
     
  Ellipse(Vertex corner,double width, double height, Vertex velocity){ 
    super(corner,width,height,velocity);
  }  
  Ellipse(Vertex corner,double width, double height){
    super(corner,width,height,v);
  }
  Ellipse(Vertex corner){
    super(corner,100,100,v);
  }
  Ellipse(){
    super(v,100,100,v);
  }
  @Override
  public String toString() {
    return "Ellipse("+corner+", "+width+", "+height+", "+velocity+")";
  }
  @Override
  double size(){
    return Math.PI*(height/2 * width/2);
  }
}


Circle
class Circle extends Ellipse {
 
  static Vertex v = new Vertex(0,0);
   
  Circle(Vertex corner,double diameter, Vertex velocity){
    super(corner,diameter,diameter,velocity);
  }
  Circle(Vertex corner,double diameter){
    super(corner,diameter,diameter,v);
  }
  Circle(Vertex corner){
    super(corner,100,100,v);
  }
  Circle(){
    super(v,100,100,v);
  }
  @Override
  public String toString() {
    return "Circle("+corner+", "+width+", "+velocity+")";
  }
 
}

SimpleArrayFuns
public final class SimpleArrayFuns {
 
  private SimpleArrayFuns() {
  }
 
  static boolean contains(int[] xs,int y){
    int match = 0;  
    for(int i=0; i<xs.length; i++){
      if(xs[i]==y) match = match + 1;
    }  
    return match > 0;
  }
  static long sum(int[] xs){
    long result = 0;
    for(int i=0; i<xs.length; i++){
      result = result + xs[i];
    }
    return result;
  }
  static int avg(int[] xs){
    double avg;
    double summe = 0;
    if (xs.length == 0) return 0;
    for(int i=0; i<xs.length; i++){
      summe = summe + xs[i];
    }
    avg = summe / xs.length;
    return (int)avg;
  }
  static boolean isSorted(int[] xs){
    int number = 0;
    for(int i=0; i<xs.length; i++){
      for(int k=i+1; k<xs.length; k++){
        if(xs[i]>=xs[k]) number = number + 1;
      }  
    }
    return number == 0;
  }
  static int max(int[] xs){
    if (xs.length == 0) return Integer.MIN_VALUE;
    int biggestNum = xs[0];  
    for(int i=0; i<xs.length; i++){
      if(xs[i]>biggestNum) biggestNum = xs[i];
    }
    return biggestNum;
  }
}

-----------------------------------------------------------------------------------------------------------------------------------------
Exercise Sheet 6
-----------------------------------------------------------------------------------------------------------------------------------------

Zeichnen von GeometricObject
package name.panitz.oose.ws17;
import javafx.scene.canvas.GraphicsContext;
 
public class GeometricObject {
  Vertex corner;
  double width;
  double height;
  Vertex velocity;
 
  public GeometricObject(Vertex corner, double width, 
      double height, Vertex velocity) {
    super();
    this.corner = corner;
    this.width = width;
    this.height = height;
    this.velocity = velocity;
  }
 
  double size(){
    return width*height;
  }
   
  boolean isLargerThan(GeometricObject that){
    return size()>that.size();
  }
  boolean isAbove(GeometricObject that){
    return corner.y+height<that.corner.y;
  }
  boolean isUnderneath(GeometricObject that){
    return that.isAbove(this);
  }
  boolean isLeftOf(GeometricObject that){
    return corner.x+width<that.corner.x;
  }
  boolean isRightOf(GeometricObject that){
    return that.isLeftOf(this);
  }
  boolean touches(GeometricObject that){
    return !(isLeftOf(that)||isRightOf(that)
        ||isAbove(that)||isUnderneath(that));
  }
  void move(){
    corner.move(velocity);
  }
  @Override
  public String toString() {
    return "Geo("+corner+","+width+","+height+","+velocity+")";
  }
 
  public void paintMeTo(GraphicsContext gc) {    
    gc.fillRect(corner.x, corner.y, width, height);
  }    
}

IsoscelesTriangle
package name.panitz.oose.ws17;
public class IsoscelesTriangle extends PolygonObject {
  double legLength;
  
  public IsoscelesTriangle(Vertex corner, double baseLength,
      double legLength, Vertex velocity) {
        
    super(corner, baseLength, Math.sqrt(Math.pow(legLength,2)
        -Math.pow(baseLength/2,2)), velocity);
    this.legLength = legLength; 
    initPolygon();
  }
  
  @Override
  void initPolygon() {
    p.add(0,height);
    p.add(width,height);
    p.add(width/2,0);
  }
  
  @Override
  public String toString() {
    return "new IsoscelesTriangle(new Vertex"
        +corner+", "+width+", "+legLength+", new Vertex"+velocity+")";
  }
  public double size(){
    return (width*height)/2.0;
  }
}

Star
package name.panitz.oose.ws17;
 
public class Star extends PolygonObject {
  int beams;
  double innerRadius;
   
  public Star(int beams,double innerRadius, Vertex corner,
      double width, Vertex velocity) {
    super(corner,width,width,velocity);
    this.beams = beams;
    this.innerRadius = innerRadius;
    initPolygon();
  }
  @Override
  public String toString() {
    return "new Star("+beams+", "+innerRadius+", new Vertex"
        +corner+", "+width+", new Vertex"+velocity+")";
  }
 
  @Override
  void initPolygon() {
    double radius = width/2;
    double theta = Math.PI * 2 / beams;
    for (int i=0; i<beams; i++) {
      p.add(radius + Math.cos(i * theta) * radius,
            radius + Math.sin(i * theta) * radius);
      p.add(radius + Math.cos(i * theta + theta / 2) * innerRadius,
          radius + Math.sin(i * theta + theta / 2) * innerRadius);
    }
  }
}

Quadrate
package name.panitz.oose.ws17;
  
public class SquaresObject extends PolygonObject{
  int depth;
  public SquaresObject(int depth,Vertex corner,double width,Vertex velocity){
    super(corner, width, width, velocity);
    this.depth = depth;
    initPolygon();
  }
  
  @Override
  public String toString() {
    return "new SquaresObject("+depth+", new Vertex"+corner+", "
        +width+", new Vertex"+velocity+")";
  }
  
  
  @Override
  void initPolygon() {
    //TODO Die Punkte der Figur ins Polygon einf¸gen
    // Berechnung der Kantenl‰nge des inneresten Quadrats 
    double oo = 1;
    for (int i = 1;i<=depth;i++){
      oo +=  2/Math.pow(3, i);
    }
    //w ist die Kantenl‰nge des inneren Quadrats
    int w = (int)(width/oo);
    drawSquare(depth, width / 2 - w / 2, width / 2 - w / 2,
            width / 2 + w / 2, width / 2 - w / 2);
    drawSquare(depth, width / 2 + w / 2, width / 2 - w / 2,
            width / 2 + w / 2, width / 2 + w / 2);
    drawSquare(depth, width / 2 + w / 2, width / 2 + w / 2,
            width / 2 - w / 2, width / 2 + w / 2);
    drawSquare(depth, width / 2 - w / 2, width / 2 + w / 2,
            width / 2 - w / 2, width / 2 - w / 2);
  }
    
  private void drawSquare(int depth, double x1, double y1,
            double x6, double y6) {
    p.add(x1, y1);
    if (depth != 0) {
      double deltaX = x6 - x1;
      double deltaY = y6 - y1;
      double x2 = x1 + deltaX / 3;
      double y2 = y1 + deltaY / 3;
      double x3 = x2 + deltaY / 3;
      double y3 = y2 - deltaX / 3;
      double x4 = x3 + deltaX / 3;
      double y4 = y3 + deltaY / 3;
      double x5 = x4 - deltaY / 3;
      double y5 = y4 + deltaX / 3;
      drawSquare(depth - 1, x2, y2, x3, y3);
      drawSquare(depth - 1, x3, y3, x4, y4);
      drawSquare(depth - 1, x4, y4, x5, y5);   
    }
    p.add(x6, y6);
  }
}

Snowflakes
package name.panitz.oose.ws17;
 
public class SnowFlake extends PolygonObject{
  int depth;
 
  SnowFlake(int depth, Vertex corner, double width, Vertex velocity) {
    super(corner, width, width, velocity);
    this.depth = depth;
    initPolygon();
  }
 
  @Override
  public String toString() {
    return "new SnowFlake("+depth+",new Vertex"+corner+","
        +width+",new Vertex"+velocity+")";
  }
   
  void initPolygon() {
    int offset = (int)(height/4.5);
    int y1 = (int)(height)-offset;
    int h = (int)(y1/2);
    int oy = 0;
    drawSnow(depth, offset/2, y1+oy, y1+offset/2, y1+oy);
    drawSnow(depth, y1+offset/2, y1+oy, h+offset/2, oy);
    drawSnow(depth, h+offset/2, oy, offset/2, y1+oy);    
  }
 
  private void drawSnow(int lev, double x1, double y1, double x5, double y5) {
    if (lev == 0) {
      p.add(x1, y1);
      p.add(x5, y5);
    } else {
      double deltaX = x5 - x1;
      double deltaY = y5 - y1;
      double x2 = x1 + deltaX / 3;
      double y2 = y1 + deltaY / 3;
      double x3 = ((x1 + x5) / 2 + (Math.sqrt(3.0) / 6) * (y1 - y5));
      double y3 = ((y1 + y5) / 2 + (Math.sqrt(3.0) / 6) * (x5 - x1));
      double x4 = x1 + deltaX * 2 / 3;
      double y4 = y1 + deltaY * 2 / 3;
      drawSnow(lev - 1, x1, y1, x2, y2);
      drawSnow(lev - 1, x2, y2, x3, y3);
      drawSnow(lev - 1, x3, y3, x4, y4);
      drawSnow(lev - 1, x4, y4, x5, y5);
    }
  }
}

-----------------------------------------------------------------------------------------------------------------------------------------
Exercise Sheet 7
-----------------------------------------------------------------------------------------------------------------------------------------

equals auf Vertex
package name.panitz.oose.ws17;
   
public class Vertex {
  double x;
  double y;
   
  public Vertex(double x, double y) {
    super();
    this.x = x;
    this.y = y;
  }
  @Override
  public String toString() {
    return "("+x+","+y+")";
  }
   
  //TODO equals ¸berschreiben
  @Override
  public boolean equals(Object that) {
    if(that == null) return false;
    if(!(that.getClass() == this.getClass())) return false;
    Vertex v =(Vertex) that;
    return Math.abs(v.x - this.x) <= 1.0
            && Math.abs(v.y - this.y) <= 1.0;
  }
}

equals auf GeometricObject
package name.panitz.oose.ws17;
  
import javafx.scene.canvas.GraphicsContext;
  
public class GeometricObject {
  Vertex corner;
  double width;
  double height;
  Vertex velocity;
  
  public GeometricObject(Vertex corner, double width, double height, 
      Vertex velocity) {
    super();
    this.corner = corner;
    this.width = width;
    this.height = height;
    this.velocity = velocity;
  }
  double size(){
    return width*height;
  }
  
  public void paintMeTo(GraphicsContext gc) {    
    gc.fillRect(corner.x, corner.y, width, height); 
  }
  
  public void move() {
    corner.x += velocity.x;
    corner.y += velocity.y;
  }
  @Override
  public String toString() {
    return corner+" "+width+" "+height;
  }
  
  boolean isLargerThan(GeometricObject that){
    return size()>that.size();
  }
  boolean isAbove(GeometricObject that){
    return corner.y+height<that.corner.y;
  }
  boolean isUnderneath(GeometricObject that){
    return that.isAbove(this);
  }
  boolean isLeftOf(GeometricObject that){
    return corner.x+width<that.corner.x;
  }
  boolean isRightOf(GeometricObject that){
    return that.isLeftOf(this);
  }
  boolean touches(GeometricObject that){
    return !(isLeftOf(that)||isRightOf(that)
        ||isAbove(that)||isUnderneath(that));
  }
  
  @Override
  public boolean equals(Object that){
    if (that == null) return false;
    if (!(that.getClass() == this.getClass())) return false;
    GeometricObject go = (GeometricObject) that;
    return ((go.corner.x - this.corner.x == 0) 
        || (go.corner.y - this.corner.y == 0)
        || (Math.abs(go.width - this.width) <= 1
        && Math.abs(go.height - this.height) <= 1));
  }
}

GeoGame
package name.panitz.oose.ws17;
  
public class SimpleGeoGame implements GeoGame {
  GeometricObject[] geos;
  int width;
  int height;
    
  public SimpleGeoGame(int width,int height, GeometricObject...
      geometricObjects) {
    geos = geometricObjects;
    this.width = width;
    this.height = height;
  }
    
  public SimpleGeoGame(GeometricObject... geometricObjects) {
    this(800,600,geometricObjects);
  }
  
  @Override
  public GeometricObject[] getGeos(){
    return geos;
  }
  @Override
  public int getWidth(){
    return width;
  }
  @Override
  public int getHeight(){
    return height;
  }
  @Override
  public void move(){
    for (GeometricObject geo:geos){
      geo.move();
    }
  }
  @Override
  public void collisionCheck(){
    double resultyy = 0;
    double resultxx = 0;
    for (GeometricObject geo:geos){
  
      if (geo.corner.x + geo.width >= getWidth() || geo.corner.x <= 0){
        geo.velocity.x *= -1;
      }  
      if (geo.corner.y + geo.height >= getHeight() || geo.corner.y <= 0){
        geo.velocity.y *= -1;
      }
      for(int i=0; i<=4; i++){
        for(int j=0; j<=4; j++){
              
          if (geos[i].touches(geos[j]) && geos[i].isLargerThan(geos[j])
              || geos[i].touches(geos[j])  && (i == 1 && j == 2)) {
            
            resultyy = geos[i].velocity.y;
            geos[i].velocity.y = geos[j].velocity.y;
            geos[j].velocity.y = resultyy;
         
            resultxx = geos[i].velocity.x;
            geos[i].velocity.x = geos[j].velocity.x;
            geos[j].velocity.x = resultxx;
          }
        }
      }
    }
  }
}

-----------------------------------------------------------------------------------------------------------------------------------------
Exercise Sheet 8
-----------------------------------------------------------------------------------------------------------------------------------------

package name.panitz.util;
    
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
    
public class AL<E> implements List<E> {
  protected E[] store = (E[]) new Object[5];
  protected int size = 0;
    
  public AL(E... es) {
    for (E e : es)
      add(e);
  }
    
  private void mkNewStore() {
    E[] newStore = (E[]) new Object[size + 5];
    for (int i = 0; i < store.length; i++)
      newStore[i] = store[i];
    store = newStore;
  }
    
  public void add(E e) {
    if (store.length <= size)
      mkNewStore();
    store[size++] = e;
  }
    
  public int size() {
    return size;
  }
    
  public E get(int i) {
    return store[i];
  }
  @Override
  public void addAll(List<E> cs){
    for(int j=0; j<cs.size(); j++){
      this.add(cs.get(j));
    }
  }
  @Override
  public void remove(int i){
    if(i < size){
      for(int k=i; k<size-1; k++){
        store[k] = get(k+1);
      }
      size -= 1;
    }
  }
  @Override
  public void insert(int i, E e) {
    if (i >= 0 && i < size){
      E temp1 = store[i];
      E temp2;
      store[i] = e;
      for (int x = i + 1; x < size; x++){
        temp2 = store[x];
        store[x] = temp1;
        temp1 = temp2;
      }
      add(temp1);
    }
    if (i >= size){
      add(e);
    }
  }
  @Override
  public boolean contains(E e){
    for(int m=0; m < size; m++){
      if(this.get(m) == e) return true;
    }
    return false;
  }
  @Override
  public boolean containsWith(Predicate<E> pred){
    for (int i = 0; i < size; i++){
      if (pred.test(get(i))){
        return true;
      }
    }
    return false;
  }
  @Override
  public void reverse(){
    E[] reverse = (E[]) new Object[size]; 
    int reverseIndex = size - 1;
    for(int n=0; n < size; n++){
      reverse[n] = store[reverseIndex];
      reverseIndex -= 1;
    }
    store = reverse;
  }
  @Override
  public void forEach(Consumer<? super E> consumer){
    for (E e: store){
      consumer.accept(e);
    }
  }
  @Override
  public boolean startsWith(List<E> that){    
    
    for (int i = 0; i < that.size(); i++){
         
      if (this.get(i) != that.get(i))
        return false;
    }
    return true;
  }
  @Override
  public boolean endsWith(List<E> that){
   
    if (this.size() == 0 && that.size() != 0){
      return false;
    }
     
    this.reverse();
    that.reverse();
    boolean result = this.startsWith(that);
    this.reverse();
    that.reverse();
    return result;
  }
  @Override
  public List<E> sublist(int i, int l){
    AL<E> subList = new AL<E>();
    if (l > size - i){
      l = size - i;
    }
    for (int x = i; x < i + l; x++){
      subList.add(get(x));
    }
    return subList;
  }
  @Override
  public void sortBy(Comparator<? super E> cmp){
    E temp;
    for (int i = size; i > 1 ; --i){
      for (int j = 0; j < i -1; ++j){
        if (cmp.compare(store[j], store[j+1]) > 0){
          temp = store[j];
          store[j] = store[j + 1];
          store[j + 1] = temp;
        }
      }
    }
  }
}
