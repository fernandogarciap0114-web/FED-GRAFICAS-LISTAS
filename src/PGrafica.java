
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import javax.swing.JPanel;

public class PGrafica extends JPanel {

    private LinkedList<Integer> valores;
    int margen = 50;
    int dx = 30;

    public PGrafica() {
        valores = new LinkedList();

    }

    public void agregarValor(int dato) {
        if (valores.size() >= 41){
            valores.remove(0);
        }
        valores.add(dato);
    }
    public void limpiarLista(){
        valores.clear();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.black);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(Color.white);
        g2.drawLine(margen, 0, margen, getHeight());//Eje Y
        g2.drawLine(0, getHeight() - margen, getWidth(), getHeight() - margen);// Eje X
        g2.setColor(Color.green);

        for (int k = 0; k < valores.size(); k++) {
            int h = getHeight();
            int vk = valores.get(k);
            int x = margen + dx * k;
            int y2 = h - margen - vk;
            int y1 = h - margen;
            g2.drawLine(x, y1, x, y2);
            g2.fillOval(x - 4, y2 - 4, 8, 8);
            g2.drawString(vk + "", x - 10, y2 - 10);
            g2.drawString(k+"", x-10, y1+20);

        }

        int[] xs = new int[valores.size() + 1];
        int[] ys = new int[valores.size() + 1];
        xs[0] = margen + dx;
        ys[0] = getHeight()- margen;
        
        for (int k = 1; k < valores.size(); k++) {
            int h = getHeight();
            int vk = valores.get(k);
            int x = margen + dx * k;
            int y = h - margen - vk;
            xs[k] = x;
            ys[k] = y;
        }
        if (valores.size() > 1) {
            int k = valores.size();
            int x = margen + dx * (k - 1);
            int y = getHeight() - margen;
            xs[k] = x;
            ys[k] = y;
        }
        g2.setColor(new Color(0, 255, 0, 100));
        g2.fillPolygon(xs, ys, valores.size() + 1);

    }

}
