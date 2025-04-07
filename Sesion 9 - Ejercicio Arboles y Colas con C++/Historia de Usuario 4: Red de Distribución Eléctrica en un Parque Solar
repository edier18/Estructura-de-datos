#include <iostream>
#include <vector>
using namespace std;
 
class Red {
    int nodos;
    vector<vector<int>> adyacente;
public:
    Red(int n) {
        nodos = n;
        adyacente.resize(n);
    }
    void conectar(int origen, int destino) {
        adyacente[origen].push_back(destino);
    }
    void mostrar() {
        for (int i = 0; i < nodos; i++) {
            cout << "Nodo " << i << " -> ";
            for (int j : adyacente[i])
                cout << j << " ";
            cout << endl;
        }
    }
};
 
int main() {
    Red red(5);
    red.conectar(0, 1);
    red.conectar(0, 2);
    red.conectar(1, 3);
    red.conectar(2, 3);
    red.conectar(3, 4);
 
    cout << "Conexiones eléctricas:\n";
    red.mostrar();
    return 0;
}
