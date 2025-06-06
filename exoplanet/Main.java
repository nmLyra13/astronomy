package exoplanet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String csvFile = "confirmed_planets.csv"; // Nome do seu arquivo CSV
        String line = "";
        String cvsSplitBy = ",";

        List<Exoplanet> exoplanets = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Ler e ignorar a primeira linha (cabeçalho)
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(cvsSplitBy, -1); // O -1 evita problemas com campos vazios no final

                // ⚠️ Ajuste: verifique as posições das colunas conforme o seu CSV.
                // Exemplo para pscomppars.csv:
                // 0 = pl_name
                // 1 = hostname
                // 2 = sy_dist (distance in parsecs)
                // 3 = pl_bmassj (mass in Jupiter masses)
                // 4 = discoverymethod

                String planetName = fields[0];
                String hostStar = fields[1];
                double distanceParsecs = parseDoubleSafe(fields[2]);
                double distanceLy = distanceParsecs * 3.26156; // Convertendo parsecs → anos-luz
                double massJupiter = parseDoubleSafe(fields[3]);
                String detectionMethod = fields[4];

                // Criar objeto Exoplanet
                Exoplanet exo = new Exoplanet(planetName, hostStar, distanceLy, massJupiter, detectionMethod);
                exoplanets.add(exo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exibir resultados
        System.out.println("Exoplanetas confirmados:");
        for (Exoplanet exo : exoplanets) {
            System.out.println(exo);
        }
    }

    // Função segura para converter String em Double
    public static double parseDoubleSafe(String value) {
        try {
            if (value == null || value.trim().isEmpty()) {
                return 0.0;
            }
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            // Se ocorrer erro (ex: "b", "unknown"), retorna 0.0
            return 0.0;
        }
    }
}
