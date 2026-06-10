package lowleveldesign.solidprinciples.isp.violations;

public interface MultiFunctionDevice {
    void print(String document);
    void scan(String document);
    void fax(String document);
}
