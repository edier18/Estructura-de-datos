#include <iostream>
#include <string>
#include <chrono>
#include <iomanip>
#include <ctime>
#include <fstream>
#include <stack>
#include <sstream>

using namespace std;


struct Registro {
    string hora;
    double consumo;
};


void encabezadoPgm() {
    string nombre = "Edier Yessid Solis Castañeda";
    string campus = "Campus Cali, U. Cooperativa de Colombia";
    string repositorioGit = "https://github.com/edier18/Estructura-de-datos";

    auto ahora = chrono::system_clock::now();
    time_t tiempo_actual = chrono::system_clock::to_time_t(ahora);
    tm* tiempo_formateado = localtime(&tiempo_actual);

    cout << endl;
    cout << "+----------------------------------------" << endl;
    cout << "| 👤 Nombre: " << nombre << endl;
    cout << "| 🎓 Campus: " << campus << endl;
    cout << "| 📅 Fecha y hora: "
         << put_time(tiempo_formateado, "%d/%m/%Y %H:%M:%S") << endl;
    cout << "| 📂 Repositorio Git: " << repositorioGit << endl;
    cout << "+----------------------------------------" << endl;
    cout << endl;
}


void leerRegistrosDesdeArchivo(const string& nombreArchivo, stack<Registro>& pila) {
    ifstream archivo(nombreArchivo);

    if (!archivo.is_open()) {
        cerr << "❌ Error al abrir el archivo: " << nombreArchivo << endl;
        return;
    }

    string linea;
    while (getline(archivo, linea)) {
        stringstream ss(linea);
        Registro reg;
        ss >> reg.hora >> reg.consumo;
        pila.push(reg);
    }

    archivo.close();
}


void mostrarRegistrosConAlertas(stack<Registro>& pila) {
    cout << "📊 Registros (orden inverso):\n\n";

    while (!pila.empty()) {
        Registro reg = pila.top();
        pila.pop();

        cout << reg.hora << " - " << reg.consumo << " kW" << endl;

        if (reg.consumo > 550) {
            cout << "⚠️  Alerta: Consumo elevado detectado!" << endl;
        }
    }
}


int main() {
    encabezadoPgm();  

    string nombreArchivo = "consumo.txt";
    stack<Registro> pilaDeConsumo;

    leerRegistrosDesdeArchivo(nombreArchivo, pilaDeConsumo);
    mostrarRegistrosConAlertas(pilaDeConsumo);

    return 0;
}
