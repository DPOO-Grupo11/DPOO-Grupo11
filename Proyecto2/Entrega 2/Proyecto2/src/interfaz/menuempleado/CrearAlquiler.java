package interfaz.menuempleado;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import clases.Inventario;
import clases.SistemaAlquiler;
import clases.Usuario;
import interfaz.Navegador;
import interfaz.componentes.Boton;
import interfaz.componentes.Combo;
import interfaz.componentes.Texto;

public class CrearAlquiler extends JPanel {

    private Usuario usuario;
    private final Navegador navegador;
    private final SistemaAlquiler sistemaAlquiler;

    public CrearAlquiler(
            Usuario usuario,
            final Navegador navegador,
            SistemaAlquiler sistemaAlquiler) {
        this.usuario = usuario;
        this.navegador = navegador;
        this.sistemaAlquiler = sistemaAlquiler;

        setLayout(new GridBagLayout());
        // categorias
        add(new Texto("Categoria:", false),
                new GridBagConstraints(
                        0, 0,
                        1, 1,
                        0, 0,
                        10, 0,
                        new Insets(0, 0, 0, 0),
                        0, 0));
        Combo comboCategoria = new Combo(Inventario.categorias, false);
        add(comboCategoria,
                new GridBagConstraints(
                        0, 1,
                        1, 1,
                        0, 0,
                        10, 0,
                        new Insets(0, 0, 0, 0),
                        0, 0));
        // sede de recogida
        add(new Texto("Sede de recogida:", false),
                new GridBagConstraints(
                        0, 2,
                        1, 1,
                        0, 0,
                        10, 0,
                        new Insets(0, 0, 0, 0),
                        0, 0));
        Combo comboRecogida = new Combo((String[]) Inventario.sedes, false);
        add(comboRecogida,
                new GridBagConstraints(
                        0, 3,
                        1, 1,
                        0, 0,
                        10, 0,
                        new Insets(0, 0, 0, 0),
                        0, 0));
        // sede de entrega
        add(new Texto("Sede de entrega:", false),
                new GridBagConstraints(
                        0, 4,
                        1, 1,
                        0, 0,
                        10, 0,
                        new Insets(0, 0, 0, 0),
                        0, 0));
        Combo comboEntrega = new Combo((String[]) Inventario.sedes, false);
        add(comboEntrega,
                new GridBagConstraints(
                        0, 5,
                        1, 1,
                        0, 0,
                        10, 0,
                        new Insets(0, 0, 0, 0),
                        0, 0));
        // sede de entrega
        add(new Texto("Medio de pago:", false),
                new GridBagConstraints(
                        0, 6,
                        1, 1,
                        0, 0,
                        10, 0,
                        new Insets(0, 0, 0, 0),
                        0, 0));
        add(new Boton("Seleccionar", () -> {
            // navegador.agregarPagina(new MetodoDePago());
            return null;
        }),
                new GridBagConstraints(
                        0, 7,
                        1, 1,
                        0, 0,
                        10, 0,
                        new Insets(0, 0, 0, 0),
                        0, 0));
    }

}
