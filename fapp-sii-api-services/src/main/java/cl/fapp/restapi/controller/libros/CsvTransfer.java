package cl.fapp.restapi.controller.libros;

import java.util.ArrayList;
import java.util.List;

public class CsvTransfer {

    private List<String[]> stringList;

    private List<RegistroCompraVentaBean> beanList;

    public CsvTransfer() {}

    public List<String[]> getStringList() {
        if (stringList != null) return stringList;
        return new ArrayList<String[]>();
    }

    public void addLine(String[] line) {
        if (this.beanList == null) this.stringList = new ArrayList<>();
        this.stringList.add(line);
    }

    public void setStringList(List<String[]> stringList) {
        this.stringList = stringList;
    }

    public void setBeanList(List<RegistroCompraVentaBean> beanList) {
        this.beanList = beanList;
    }

    public List<RegistroCompraVentaBean> getBeanList() {
        if (beanList != null) return beanList;
        return new ArrayList<RegistroCompraVentaBean>();
    }
}
