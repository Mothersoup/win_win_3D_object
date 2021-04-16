import javax.media.j3d.TransformGroup;

public class Depencies {
 private   TransformGroup rotateNeed=new TransformGroup();
    TransformGroup getTransfromGroup()
    {
    return rotateNeed;
    }
    public  TransformGroup setTransfromGroup(TransformGroup transformGroup) {
        rotateNeed = transformGroup;
    return rotateNeed;
    }
}
