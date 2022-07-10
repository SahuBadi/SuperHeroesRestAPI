# SuperHeroesRestAPI
SuperHeroesRestAPI


**Api REST SuperHeroes:**
Proyecto Maven con Spring Boot y conexión a base de datos PostgreSQL. Java versión 11.

**Dependencias:**
- Spring Boot Dev Tools
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Lombok

**Entidades del proyecto y sus tablas:**
- SuperHeroe  --*superheroes*
- Universe  --*universes*
- SuperPower  --*superpowers*
- Tabla enlace: --*superheroe_superpowers*

**Estructura para la inserción de SuperHeroes:**

      "name": " ",
      "realName": " ",
      "Universe": {
            "name": " ",
            "description": " "
      },
      "superPowers": [
          {
              "name": " ",
              "description": " "
          }
      ],
      "alive": true

  
  
  ***

## ENDPOINTS


  
   **SUPERHEROE** 
   - Get SuperHeroe
     - All: /api/superheroes
     - by Id: /api/superheroes/{id}
   
   - Post SuperHeroe
     - /api/superheroes
   - Put SuperHeroe
      - /api/superheroes/{id}
      - To kill: /api/superheroes/kill/{id}
      - To resurrect: /api/superheroes/revive/{id}
   - Delete SuperHeroe
      - /api/superheroes/{id}
  
  **UNIVERSE**
  - Get Universe
    - All: /api/universes
    - by Id: /api/universes/{id}
   - Post Universe
     - /api/universes
   - Put Universe
      - /api/universes/{id}
   - Delete Universe
      - /api/universes/{id}
  
   **SUPERPOWER**
  - Get SuperPower
    - All: /api/superpowers
    - by Id: /api/superpowers/{id}
  - Post SuperPower
    - /api/superpowers
   - Put SuperPower
     - /api/superpowers/{id}
     
   - Delete SuperPower
      - /api/superpowers/{id}
      
      
      
      
      ----------------------------------------------
