import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumNumberofVisiblePoints {
    public static void main(String[] args) {
        System.out.println(new MaximumNumberofVisiblePoints()
                .visiblePoints(new ArrayList<>(
                                Arrays.asList(Arrays.asList(198768142,325231488),Arrays.asList(730653894,526879029),Arrays.asList(482566443,124650516),Arrays.asList(301750308,786306795),Arrays.asList(428637509,388444545),Arrays.asList(824139468,560868920),Arrays.asList(46101719,541790947),Arrays.asList(33117389,306138652),Arrays.asList(379129552,739264502),Arrays.asList(632078701,382510936),Arrays.asList(648669937,641406148),Arrays.asList(402494603,290848535),Arrays.asList(681757446,651339050),Arrays.asList(755146968,328108553),Arrays.asList(856055968,54585842),Arrays.asList(642810790,781285498),Arrays.asList(624780623,839525682),Arrays.asList(225552068,597591380),Arrays.asList(941428680,575243295),Arrays.asList(904246597,409781914),Arrays.asList(133988308,424694994),Arrays.asList(263860625,642729245),Arrays.asList(725256971,428462957),Arrays.asList(951188673,24284291),Arrays.asList(65878467,597579989),Arrays.asList(423910337,760218568),Arrays.asList(375233659,465709839),Arrays.asList(39079416,44449206),Arrays.asList(76488044,376497238),Arrays.asList(768046853,401132958),Arrays.asList(862857872,713625310),Arrays.asList(834212457,613684155),Arrays.asList(145940546,414657761),Arrays.asList(438671565,895069996),Arrays.asList(486059332,78047139),Arrays.asList(539611528,236860222),Arrays.asList(328891159,833572609),Arrays.asList(561041358,896191043),Arrays.asList(469734995,511499580),Arrays.asList(868786087,593647615),Arrays.asList(502014973,630219398),Arrays.asList(834825976,939531210),Arrays.asList(232809706,831430339),Arrays.asList(446916520,518080962),Arrays.asList(516594877,208057152),Arrays.asList(851130172,768268153),Arrays.asList(665228968,134767900),Arrays.asList(347594646,46036486),Arrays.asList(675842115,24895986),Arrays.asList(877430373,353382710),Arrays.asList(167579980,47992154),Arrays.asList(125351210,769215749),Arrays.asList(438404131,569154245),Arrays.asList(604952972,128325995),Arrays.asList(304627075,646626043),Arrays.asList(651998767,527382342),Arrays.asList(121415369,22955171),Arrays.asList(46278664,726969424),Arrays.asList(650197837,730272955),Arrays.asList(326340006,424213045),Arrays.asList(242071539,679004233),Arrays.asList(208227275,449583956),Arrays.asList(688763276,330569373),Arrays.asList(657221239,659946024),Arrays.asList(760680906,398786962),Arrays.asList(695186876,163719246),Arrays.asList(416909447,908414565),Arrays.asList(59247263,674732497),Arrays.asList(396812330,607544608),Arrays.asList(752069054,728117920)
                                ))
                        ,86,Arrays.asList(136181398,475556834))); //2
//        System.out.println(new MaximumNumberofVisiblePoints()
//                .visiblePoints(new ArrayList<>(
//                                Arrays.asList(Arrays.asList(2,1),Arrays.asList(2,2),Arrays.asList(3,4),Arrays.asList(1,1)))
//                        ,90,Arrays.asList(1,1))); //4
//        System.out.println(new MaximumNumberofVisiblePoints()
//        .visiblePoints(new ArrayList<>(
//                Arrays.asList(Arrays.asList(956,232),Arrays.asList(438,752),Arrays.asList(595,297),Arrays.asList(508,143),Arrays.asList(111,594),Arrays.asList(645,824),Arrays.asList(758,434),Arrays.asList(447,423),Arrays.asList(825,356),Arrays.asList(807,377)))
//                ,38,Arrays.asList(74,581))); //7
//        System.out.println(new MaximumNumberofVisiblePoints()
//                .visiblePoints(new ArrayList<>(
//                                Arrays.asList(Arrays.asList(0,0),Arrays.asList(0,2)))
//                        ,90,Arrays.asList(1,1))); //2
    }
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> pointAngles=new ArrayList<>();
        int same=0;
        for(List<Integer> point:points){
            int difX=point.get(0)-location.get(0);
            int difY=point.get(1)-location.get(1);
            if(difX==0&&difY==0)
                same++;
            else{
                double angleDif=Math.atan2(difY, difX) * 180 / Math.PI;
                angleDif=(angleDif<0?360+angleDif:angleDif)%360;
                pointAngles.add(angleDif);
            }
        }
      Collections.sort(pointAngles);
      int result=0;
      for(int i=0;i<pointAngles.size();i++){
          double curAngle=pointAngles.get(i);
          double leftViewAngle = (angle + curAngle)%360;
          int max=Collections.binarySearch(pointAngles,leftViewAngle);
          if(max<0){
              max*=-1;
              max-=2;
          }
          max= Math.min(max,pointAngles.size()-1);
          while(max<pointAngles.size()-1 && pointAngles.get(max+1)==leftViewAngle)
              max++;
          int curResult=max-i+1;
          if(angle + curAngle>360){
              curResult=pointAngles.size()-curResult+2;
          }
          result=Math.max(result,curResult);
      }
      return result+same;
    }
}
