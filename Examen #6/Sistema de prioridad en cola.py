import heapq

class SoporteTecnico:
    def __init__(self):
        self.cola_prioridad = []
        self.prioridades = {"crítica": 1, "importante": 2, "general": 3}
    
    def agregar_solicitud(self, prioridad, descripcion):
                                                                          #Agrega una nueva solicitud a la cola con prioridad
        if prioridad in self.prioridades:
            heapq.heappush(self.cola_prioridad, (self.prioridades[prioridad], descripcion))
            print(f"Solicitud agregada: {prioridad.upper()} - {descripcion}")
        else:
            print("Prioridad no válida. Use: crítica, importante o general.")
    
    def atender_solicitud(self):
                                                                         #Atiende la solicitud más prioritaria y la elimina de la cola
        if self.cola_prioridad:
            prioridad, descripcion = heapq.heappop(self.cola_prioridad)
            print(f"Atendiendo solicitud: {descripcion} (Prioridad: {prioridad})")
        else:
            print("No hay solicitudes pendientes.")
    
    def mostrar_solicitudes(self):
                                                                          #Muestra la lista de solicitudes pendientes en orden de prioridad
        if self.cola_prioridad:
            print("Solicitudes pendientes:")
            for prioridad, descripcion in sorted(self.cola_prioridad):
                print(f"- {descripcion} (Prioridad: {prioridad})")
        else:
            print("No hay solicitudes pendientes.")

                                                                        # Ejemplo de uso
if __name__ == "__main__":
    soporte = SoporteTecnico()
    soporte.agregar_solicitud("crítica", "Servidor caído")
    soporte.agregar_solicitud("importante", "Actualización de software")
    soporte.agregar_solicitud("general", "Soporte de usuario")
    
    soporte.mostrar_solicitudes()
    soporte.atender_solicitud()
    soporte.mostrar_solicitudes()