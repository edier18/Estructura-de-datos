from collections import deque

class CentroMedico:
    def __init__(self):
        self.turnos = deque()
    
    def agregar_turno(self, paciente):
        """Agrega un nuevo turno al final de la lista."""
        self.turnos.append(paciente)
        print(f"{paciente} ha sido agregado a la lista de turnos.")
    
    def atender_paciente(self):
        """Atiende al primer paciente en la lista y lo elimina."""
        if self.turnos:
            paciente = self.turnos.popleft()
            print(f"Atendiendo a {paciente}.")
        else:
            print("No hay pacientes en espera.")
    
    def mostrar_turnos(self):
        """Muestra la lista de turnos pendientes."""
        if self.turnos:
            print("Turnos pendientes:", list(self.turnos))
        else:
            print("No hay turnos pendientes.")

# Ejemplo de uso
if __name__ == "__main__":
    centro = CentroMedico()
    centro.agregar_turno("Ana Gómez")
    centro.agregar_turno("Luis Torres")
    centro.agregar_turno("Juan Pérez")
    
    centro.mostrar_turnos()
    centro.atender_paciente()
    centro.mostrar_turnos()