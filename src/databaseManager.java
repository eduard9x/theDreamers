import java.sql.*; // imports all the sql classes

public class databaseManager {

    //variables that will help to connect to DB
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private final String query = "SELECT * FROM theDreamersTable WHERE id=";
    private String answer1 = "", answer2 = "", answer3 = "", answer4 = "";
    private final int databaseSize = 90;
    private int[] generateNumbers = new int[databaseSize];

    public databaseManager() {

        generateNumbers();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theDreamersDatabase", "root", "");
            //connection to my personal database
            st = con.createStatement();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void generateNumbers() {
        double number = Math.random() * databaseSize + 1;
        int position = (int) number;
        generateNumbers[0] = position;

        int i = 1;
        while (i < databaseSize) {
            number = Math.random() * databaseSize + 1;
            position = (int) number;
            if (isValid(position, i)) {
                generateNumbers[i] = position;
                i++;
            }
        }
    }

    public boolean isValid(int number, int lastPosition) {
        for (int i = 0; i < lastPosition; i++)
            if (generateNumbers[i] == number) return false;
        return true;
    }


    public String getDataQuestion(int number) {
        String question = "";
        try {
            rs = st.executeQuery(query + number);

            while (rs.next())
                question = rs.getString("Question");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return question;
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getAnswer1(int number) {
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer1 = rs.getString("Answer1"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer1;
    }

    public String getSubject(int number) {
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer1 = rs.getString("Subject"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer1;
    }

    public String getAnswer2(int number) {
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer2 = rs.getString("Answer2"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer2;
    }

    public String getAnswer3(int number) {
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer3 = rs.getString("Answer3"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer3;
    }

    public String getAnswer4(int number) {
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer4 = rs.getString("Answer4"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer4;
    }

    public void deleteData() {
        try {
            String sql = "DELETE  FROM  theDreamersTable ";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    // DB WRITE
    public void writeData() {
        try {
            //("INSERT INTO theDreamers " + "VALUES (id, 'Question', 'Answer1(Correct)', 'Answer2', 'Answer3', 'Answer4', 'Subject')");
            // Q //
            /* 1 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[0]) + ", 'Solve (11-5)x(63-59+6)/12', '5', '7', '8', '10', 'Maths')");
            /* 2 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[1]) + ", 'Find the HCF(Highest Common Factor) and LCM(Lowest Common " +
                    "Multiple) of the following pair of numbers: 120,336', '24 and 1680', '16 and 1820', '2 and 203', '23 and 1680', 'Maths')");
            /* 3 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[2]) + ", 'Convert to the decimal form to 4 decimal places: -6/13'," +
                    " '-0.4615', '-0.3615', '-0.9615', '-0.2615', 'Maths')");
            /* 4 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[3]) + ", 'Complete the square: x2 - 12x + 18'," +
                    " '(x-6)2 - 18', '(y-6)2 - 18', '(x-3)5 - 16', '(x-4)3 - 12', 'Maths')");
            /* 5 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[4]) + ", 'Find the sum of the roots of quadratic equation: x2 - 15x + 2.5 = 0', " +
                    "'15', '17', '19', '10', 'Maths')");
            /* 6 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[5]) + ", 'Solve by factor method: x2+11x+18=0', " +
                    "'x=-2 and x=-9', 'x=-3 and x=-6', 'x=-5 and x=-10', 'x=-7 and x=-11', 'Maths')");
            /* 7 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[6]) + ", 'Solve using factor method: 5x2-26x+24=0', " +
                    "'x=6, x=224', 'x=3, x=213', 'x=2, x=124', 'x=8, x=367', 'Maths')");
            /* 8 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[7]) + ", 'Find the gradient of a straight line with the points P(5,3) and Q(8,12).', " +
                    "'3', '7', '8', '10', 'Maths')");
            /* 9 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[8]) + ", 'Find the factors of 2x3+7x2-5x-4', " +
                    "'2(x-1)(x+1/2)(x+4)', '3(x-2)(x+2/1)(x+3)', '2(x-1)(x+1/3)(x+3)', '4(x-3)(x+2/2)(x+2)', 'Maths')");
            /* 10 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[9]) + ", 'Find the repeated factor of x3-3x2+4', " +
                    "'(x-2)', '(x-1)', '(x-3)', '1(x-4)', 'Maths')");
            /* 11 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[10]) + ", 'Solve: (2+3i)(3+4i)', " +
                    "'-6+17i', '-5+24i', '-6+16i', '1-6+12i', 'Maths')");
            /* 12 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[11]) + ", 'Simplify: (3-4i)2', " +
                    "'-7-24i', '-8-23i', '-5-21i', '-6-24i', 'Maths')");
            /* 13 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[12]) + ", 'If (x+y)+i(x-y)=5+3i, find x and y', " +
                    "'x=4,y=1', 'x=3,y=2', 'x=1,y=4', 'x=4,y=2', 'Maths')");
            /* 14 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[13]) + ", 'Express 3(cos15°+isin15°) in the form a+ib.', " +
                    "'2.898+0.777i', '2.998+0.666i', '2.798+1.671i', '2.658+1.757i' , 'Maths')");
            /* 15 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[14]) + ", 'Which of the following are geometric series?', " +
                    "'4,8,16...', '3,4,10...', '2,4,74...', '1,2,5...', 'Maths')");
            /* 16 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[15]) + ", 'Find a common ratio in the following geometric series: 5,15,45...', " +
                    "'r=3', 'r=4', 'r=2', 'r=5', 'Maths')");
            /* 17 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[16]) + ", 'Find the 14th term in the following geometric series: 12,6,3...', " +
                    "'a14=0.00146', 'a15=0.00164', 'a14=0.00164', 'a14=0.00126', 'Maths')");
            /* 18 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[17]) + ", 'What is the common difference in the following arithmetic series: 2.5,6.4,10.3,...?', " +
                    "'3.9', '2.9', '4.0', '3.8', 'Maths')");
            /* 19 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[18]) + ", 'What is the 31st term in the following arithmetic series: 45,42.5,40...?', " +
                    "'-30', '-29', '-31', '-03', 'Maths')");
            /* 20 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[19]) + ", 'If x=5, find: 5x + 7'," +
                    " '32', '33', '31', '30', 'Maths')");
            /* 21 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[20]) + ", 'State the binary representation of the denary number 91.'," +
                    " '1011011', '111011', '111011', '1111011', 'Computer Science')");
            /* 22 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[21]) + ", 'State the denary equivalent of this pattern 10110110.'," +
                    " '182', '183', '181', '180', 'Computer Science')");
            /* 23 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[22]) + ", 'State the hexadecimal equivalent of the denary number 182.'," +
                    " 'B6', 'B7', 'B5', 'B8', 'Computer Science')");
            /* 24 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[23]) + ", 'What is meant by an algorithm?'," +
                    " 'Sequence of steps that solve a problem.', 'Sequence of steps to create UI.', 'Sequence of steps that create UX', 'Sequence of steps that solve question', 'Computer Science')");
            /* 25 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[24]) + ", 'Machine code is the first generation of programming language. What is the second generation of programming language?'," +
                    " 'Assembly code', 'Function code', 'Class code', 'Interface code', 'Computer Science')");
            /* 26 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[25]) + ", 'What does the term peripheral mean?'," +
                    " 'A hardware device', 'A software device', 'A terminal device', 'A console device', 'Computer Science')");
            /* 27 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[26]) + ", 'URL : https://www.westminster.ac.uk/ - State the top-level domain part in the URL.'," +
                    " '.uk', '.co', 'www.', 'https:', 'Computer Science')");
            /* 28 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[27]) + ", 'What is the role of a DNS server?'," +
                    " 'To take a required FQDN and to return an IP address.', 'To take a required HTTP and to return an IP address.', 'To take a required IPS and to return an IP address.', 'To take a required Password and to return an IP address.', 'Computer Science')");
            /* 29 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[28]) + ", 'What problem has resulted from performing the calculation using 8-bit two’s complement binary?'," +
                    " 'The result is too large to be represented.', 'The result is extra large to be represented.', 'The result is too small to be represented.', 'The result is extra small to be represented.', 'Computer Science')");
            /* 30 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[29]) + ", 'Write the HTML code required for a link to www.westminster.ac.uk. The link should be ‘Click me to go to the university’s website’'," +
                    "'&lt;a href= “https://www.westminster.ac.uk/”&gt; Click me to go to the university’s website &lt;/a&gt;', '&lt;a class= “https://www.westminster.ac.uk/”&gt; Click me to go to the university’s website &lt;/a&gt;', '&lt;a id= “https://www.westminster.ac.uk/”&gt; Click me to go to the university’s website &lt;/a&gt;', '&lt;a style= “https://www.westminster.ac.uk/”&gt; Click me to go to the university’s website &lt;/a&gt;', 'Computer Science')");
            /* 31 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[30]) + ", 'State Hooke’s Law'," +
                    " 'Force proportional to extension', 'Range proportional to extension', 'Distance proportional to extension', 'Intensity proportional to extension', 'Science')");
            /* 32 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[31]) + ", 'Which of these is a reason fire breathers can’t breathe properly after years of doing it?'," +
                    " 'Less elasticity', 'More elasticity', 'Less electricity', 'More electricity', 'Science')");
            /* 33 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[32]) + ", 'Which is a way in which antibiotics can prevent the growth of bacteria?'," +
                    " 'Prevent cell wall formation', 'Provide cell wall formation', 'Prevent gene wall formation', 'Provide gene wall formation', 'Science')");
            /* 34 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[33]) + ", 'Ammonia gas readily condenses to form a liquid when cooled. Name the strongest attractive force between two ammonia molecules. '," +
                    " 'Hydrogen bonds', 'Oxygen bonds', 'Nitrogen bonds', 'Carbon bonds', 'Science')");
            /* 35 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[34]) + ", 'Name an element that has a half-filled set of p-orbital'," +
                    " 'Nitrogen', 'Oxygen', 'Hydrogen', 'Carbon', 'Science')");
            /* 36 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[35]) + ", 'Which of the following carry a negative charge?'," +
                    " 'Electron', 'Proton', 'Neutrons', 'Nucleus', 'Science')");
            /* 37 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[36]) + ", 'Name the process that resulted in the development of woodland from farmland.'," +
                    " 'Succession', 'Disturbance', 'Photosynthesis', 'The Carbon Cycle', 'Science')");
            /* 38 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[37]) + ", 'The genetic code uses four different DNA bases. What is the maximum number of different DNA triplets that can be made using these four bases?'," +
                    " '64', '32', '128', '16', 'Science')");
            /* 39 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[38]) + ", 'Transcription of a gene produces pre-mRNA. Name the process that removes base sequences from pre-mRNA to form mRNA.'," +
                    " 'Splicing', 'Splitting', 'Spinning', 'Storming', 'Science')");
            /* 40 */
           st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[39]) + ", 'Which one of the following is a fundamental particle that would not be deflected by an electric field?'," +
                    " 'Neutron', 'Atom', 'Proton', 'Neutron', 'Nucleus')");
            /* 41 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[40]) + ", 'Which of the following element that has a half-filled set of p-orbitals.'," +
                    " 'Nitrogen', 'Oxygen', 'Hidyrogen', 'Carbon', 'Science')");
            /* 42 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[41]) + ", 'Which of the following carry a negative charge?'," +
                    " 'electron and beta-particle', 'electron and alpha-particle', 'proton and meta-particle', 'proton and alpha-particle', 'Science')");
            /* 43 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[42]) + ", 'Name the enzyme that can extend a cell’s life, by subverting the “normal” ageing process shorten with each division of a cell?'," +
                    " 'Telomerase', 'Telomere', 'Nucleotide', 'Angiogenesis', 'Science')");
            /* 44 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[43]) + ", 'What are different masses of an atom in the same element called?'," +
                    " 'Isotopes', 'Protium', 'Deuterium', 'Tritium', 'Science')");
            /* 45 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[44]) + ", 'On a molecular level, why is water such a good solvent?'," +
                    " 'it is polar', 'it is air', 'it is ice', 'it is sea', 'Science')");
            /* 46 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[45]) + ", '6.02x10^23 represents which number?'," +
                    " 'Avogrado’s number', 'PI number', 'Graham’s number', 'Golden number', 'Science')");
            /* 47 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[46]) + ", 'Which of the following statements is true about noble gases?'," +
                    " 'They are very non-reactive', 'They are very active', 'They are non-reactive', 'They are not very non-reactive', 'Science')");
            /* 48 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[47]) + ", '8. Glycolysis is the process of breaking glucose down into what?'," +
                    " 'Pyruvate', 'Lactate', 'Oxaloacetate', 'Acetyl CoA', 'Science')");
            /* 49 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[48]) + ", 'Which organelle is responsible for carrying proteins to amino acid during DNA synthesis?'," +
                    " 'Ribosomes', 'Nucteotide', 'Polypeptide', 'Terminus', 'Science')");
            /* 50 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[49]) + ", 'The Fibonacci Sequence is an example of which kind of formula?'," +
                    " 'Recursion', 'Inverse', 'Hyperbolic', 'Calculus', 'Science')");
            /* 51 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[50]) + ", 'Which sentence describes one impact of climate change upon global precipitation rates?',"
                    + "'Temperatures will rise leading to increased evaporation and higher amounts of rainfall in many places with more intense bursts.', 'Increased cloud cover will mean lower temperatures and less evaporation leading to less rainfall but falling in shorter bursts.' , 'Temperatures will rise leading to increased evaporation, lower rainfall and more intermittent rainfall.' , 'The higher temperatures will cause the ice caps to melt putting more water into the oceans. Sea levels will rise and hurricanes will be more likely as the sea level rises.' ,'Geography')");
            /* 52 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[51]) + ", 'Which terms apply to land-based transfers of water?', " +
                    "'Overland flow and infiltration.', 'Condensation and groundwater flow.', 'Evaporation and infiltration.', 'Precipitation and evaporation', 'Geography')");
            /* 53 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[52]) + ", 'To what does the carbon budget refer?',"
                    + " 'The balance of exchanges between the four major stores of carbon.', 'The measurement of the quantity of transferred carbon between land and ocean.', 'The total quantity of the major stores of carbon.', 'The amount of carbon in the atmosphere at any one time.', 'Geography')");
            /* 54 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[53]) + ", 'Why are some rivers in hot deserts ephemeral?', "
                    + "'Because the heavy bursts of intermittent rainfall bring the river to life, but it quickly dries up once the water source has gone.', 'Because rivers which flow from areas with higher rainfall through deserts have a constant supply of water and it never dries up.', 'Because the water supply comes from an underground spring and keeps flowing all year round despite the very low rainfall.', 'Because the water supply comes from underground and the hot conditions during the day mean it quickly evaporates.', 'Geography')");
            /* 55 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[54]) + ", 'Wind has a direct impact on the development of which erosional landforms?', "
                    + "'Yardangs, ventifacts and zeugen.', 'Zeugen, dunes and wadis.', 'Yardangs, bahadas and inselbergs.', 'Pediments, ventifacts and inselbergs.', 'Geography')");
            /* 56 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[55]) + ", 'Which of the following is a cause of desertification?',"
                    + "'Climate change which is creating even drier desert areas with semi-arid areas becoming arid.', 'Adding natural fertiliser to farmland in arid areas in order to allow intensive cultivation.', 'Building settlements in desert areas which creates large areas of hard surfaces, increasing runoff and erosion of top soils.', 'The harvesting of wood in desert areas which interferes with convectional rainfall, reducing precipitation rates.', 'Geography')");
            /* 57 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[56]) + ", 'Which of the following describes the sediment budget?',"
                    + "'The relationship between deposition and erosion, which can be used to predict the changing shape of a coastline over time.', 'The impact of wind on the build-up of sand dunes in places such as the Netherlands.', 'The interaction between waves, currents and tides and how these factors determine whether a coastline is more or less likely to be eroded.', 'The relationship between erosion, weathering and mass movements and how these affect the land at the coast.', 'Geography')");
            /* 58 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[57]) + ", 'Where do erosional coastal landscapes tend to develop?',"
                    + " 'Where there are frequently strong winds and deep water leading to the formation of destructive waves.', 'Where there is a large fetch, a shallow bay and constructive waves.', 'Where there are frequent areas of low pressure in areas of shallow water, especially around estuaries.', 'Where there are easily eroded rocks in areas of shallow water.', 'Geography')");
            /* 59 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[58]) + ", 'Where do sand dunes tend to form?',"
                    + " 'Where there is a large supply of sand in low energy environments, with a large tidal range and a prevailing onshore wind.', 'Where the destructive power of the waves pushes sand up a beach in storm conditions.', 'Where low energy environments and low tidal range creates large supplies of sand in bays.', 'Where estuaries release large quantities of sediment and the dunes form in the area landward of a spit, colonised by vegetation, which further stabilises the dune.', 'Geography')");
            /* 60 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[59]) + ", 'Which of these phrases describes what is meant by the globalisation of the world economy?', "
                    + "'Economic integration arising from exchange of products, ideas, capital and labour between countries.', 'The fact that China exports cheap manufactured goods to developed countries like the UK and imports oil and minerals from Africa and other poor countries.', 'The growth of newly emerging countries like China and India as major world economies.', 'The outsourcing of industry and services from more developed countries to less developed countries.', 'Geography')");
            /* 61 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[60]) + ", 'Which of these phrases describes the global commons?', "
                    + "'The Earth’s shared natural resources, such as the deep oceans, the atmosphere, outerspace and the polar regions.', 'Open space that is controlled by the United Nations and not owned by any one country.', 'Land with public rights of way through the countryside and open access to land such as mountains and moorland.', 'Land set aside for the grazing of cattle where no one is allowed to fence off the land into enclosures.', 'Geography')");
            /* 62 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[61]) + ", 'Which of these pairs of statements can both be applied to all transnational corporations (TNCs)?',"
                    + " 'They operate in more than one country. They need to move capital from one country to another.', 'They outsource jobs from rich countries to poor countries. They are more economically powerful than the countries in which they operate.', 'The taxes that they pay are the main sources of revenue for many countries. They make high-tech products and pharmaceuticals.', 'Their headquarters are in more developed countries. They trade in several different countries.', 'Geography')");
            /* 63 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[62]) + ", 'Which statement best explains why most of the population of the people’s Republic of China live in the eastern third of the nation?', "
                    + "'best agricultural land is in the East', 'largest forests are in the East', 'best fishing areas are off the eastern coast', 'largest oil deposits are in the East', 'Geography')");
            /* 64 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[63]) + ", 'In Japan, a major economic problem has been the lack of', "
                    + "'natural resources', 'investment capital', 'skilled labor', 'experienced management', 'Geography')");
            /* 65 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[64]) + ", 'Both Japan and Indonesia are made up of a chain of islands called', "
                    + "'an archipelago', 'a peninsula', 'a delta', 'an atoll', 'Geography')");
            /* 66 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[65]) + ", 'Characteristics of constructive waves include:', "
                    + "'Long Wavelength', 'Strong Wash', 'Gentle waves', 'Long wave period', 'Geography')");
            /* 67 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[66]) + ", 'Processes operating at the coast include', "
                    + "'Attrition, sub-aerial, hydraulic pressure, corrasion', 'Abrasion, human activity, sub-aerial, long shore drift', 'Attrition, solution, wave steepness, wave pounding', 'Wave pounding, attrition, human activity, long shore drift', 'Geography')");
            /* 68 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[67]) + ", 'Wave trough is', "
                    + "'The lowest point of a wave', 'Number of waves per minute', 'Distance between wave crests', 'Time between wave crests', 'Geography')");
            /* 69 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[68]) + ", 'The correct sequence leading to the formation of a stump is', "
                    + "'Geo, cave, arch, stack', 'Arch, blowhole, geo, stack', 'Blowhole, cave, geo, stack', 'Cave, arch, geo, stack', 'Geography')");
            /* 70 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[69]) + ", 'Many spits have curved ends because',"
                    + " 'Wave refraction operates at the end of the spit', 'Rivers limit deposition', 'Salt marshes develop in areas of shelter', 'Human activity is in operation', 'Geography')");
            /* 71 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[70]) + ", 'Which document is an example of a primary source?',"
                    + " 'the diary of a survivor of a Nazi death camp', 'a novel on the Age of Exploration', 'San encyclopedia article on religions of the Middle East', 'a textbook on Russian history', 'History')");
            /* 72 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[71]) + ", 'Which historical events are in the correct chronological order?',"
                    + " 'Neolithic Revolution -> Roman Empire -> Crusades -> Renaissance', 'Renaissance -> Neolithic Revolution -> Crusades -> Roman Empire', 'Roman Empire -> Neolithic Revolution -> Crusades -> Renaissance', 'Crusades -> Renaissance -> Neolithic Revolution -> Roman Empire', 'History')");
            /* 73 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[72]) + ", 'Which condition is most necessary to the process of industrialization in a society?',"
            + " 'creation of a one-crop economy', 'capture of foreign lands', 'invasion of a foreign lands', 'dependence on subsistence agriculture', 'History')");
            /* 74 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[73]) + ", 'According to Karl Marx, history is the record of the',"
            + " 'struggle between classes in society', 'granting of more political liberties to all people', 'wars and conflicts between national leaders', 'increasing prosperity brought about by industrialization', 'History')");
            /* 75 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[74]) + ", 'A main idea of Karl Marx and Friedrich Engles’ Communist Manifesto is that the proletariat:',"
            + " 'must unite to overthrow the capitalist class', 'should allow the capitalists to control the means of production', 'had to cooperate with the capitalists to gain economic rewards', 'would need foreign help to achieve its revolutionary ends', 'History')");
            /* 76 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[75]) + ", 'Which argument did President Abraham Lincoln use against the secession of the Southern States?',"
            + " 'The government was a union of people and not of states', 'Slavery was not profitable', 'The Southern States did not permit their people to vote on secession', 'As the Commander in Chief, he had the duty to defend the United States against foreign invasion', 'History')");
            /* 77 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[76]) + ", 'The abolitionist movement, the women’s suffrage movement, and the 1960’s civil rights movement are all examples of reform efforts that:',"
            + " 'B - developed significant popular support', 'succeeded without causing major controversy', 'achieved their goals without government action', 'failed to affect the nation as a whole', 'History')");
            /* 78 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[77]) + ", 'Which statement best explains President Abraham Lincoln’s justification for the Civil War?',"
            + " 'President Lincoln’s oath of office required him to defend and preserve the Union', 'President Lincoln wanted to keep the South economically dependent on the industrial North', 'As an abolitionist, President Lincoln wanted to end slavery in the United States.', 'To keep the support of Great Britain and France, President Lincoln had to try to end slavery immediately', 'History')");
            /* 79 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[78]) + ", 'A major result of the Civil War was that the',"
            + " 'Federal Government’s power over the States was strengthened', 'economic system of the South came to dominate the United State economy', 'members of Congress from Southern States gained control of the legislative branch', 'nation’s industrial development came to a standstill', 'History')");
            /* 80 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[79]) + ", 'Sectional differences developed in the United States largely because',"
            + " 'economic conditions and interests in each region varied', 'the Federal Government adopted a policy of neutrality', 'early Presidents favored urban areas over rural areas', 'Different religions occured in different regions', 'History')");
            /* 81 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[80]) + ", 'A major cause of the growth of state and Federal highway systems after World War II was the',"
            + " 'rapid development of suburbs', 'return of city dwellers to farm areas', 'growing prosperity of inner-city areas', 'increased use of mass transit systems', 'History')");
            /* 82 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[81]) + ", 'During World War II, women and minorities made economic gains mainly because:',"
            + " 'a shortage of traditional labor created new opportunities in the workplace', 'more educational opportunities increased the number of skilled workers in these groups', 'labor unions successfully demanded equal opportunities for these groups', 'new civil rights legislation forced businesses to change their hiring practices', 'History')");
            /* 83 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[82]) + ", 'A major cause of the internment of Japanese Americans during World War II was',"
            + " 'racial prejudice', 'immigration quotas', 'national segregation policies', 'economic depression', 'History')");
            /* 84 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[83]) + ", 'A violation of civil rights that occurred in the United States during World War II was the:',"
            + " 'internment of Japanese Americans', 'passage of an open immi-gration law', 'arrests made as a result of the Palmer raids', 'forced removal of Native American Indians from their reservations', 'History')");
            /* 85 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[84]) + ", 'Which action best illustrates the policy of isolationism followed by the United States before it entered World War II?',"
            + " 'passage of neutrality legislation forbidding arms sales to warring nations', 'signing of a collective security pact with Latin American nations', 'embargo on the sale of gasoline and steel to Japan', 'President Franklin D. Roosevelt’s exchange of American destroyers for British naval and air bases', 'History')");
            /* 86 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[85]) + ", 'In the 1930’s, the United States attempted to avoid a repetition of the events leading up to United States involvement in World War I by:',"
            + " 'passing a series of neutrality laws', 'establishing the Good Neighbor policy with Latin American nations', 'forgiving the foreign debts incurred during World War I', 'officially recognizing the existence of the Soviet Union', 'History')");
            /* 87 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[86]) + ", 'After World War II, the United States was better able than its allies to adjust its economy from wartime to peacetime because the United States',"
            + " 'had suffered no widespread wartime destruction', 'possessed nuclear weapons', 'raised tariffs on imports', 'had collected its war debts from the Allies', 'History')");
            /* 88 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[87]) + ", 'Which congressional action not only raised money for World War II but also contributed to the national debt?',"
            + " 'selling war bonds', 'raising income tax rates', 'requiring employers to withhold taxes from workers’ paychecks', 'enacting wage and price controls', 'History')");
            /* 89 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[88]) + ", 'What was a key challenge faced by the United States during World War II?',"
            + " 'fighting the war on several fronts', 'lack of public support for the war effort', 'difficulty gaining congressional support', 'total reliance on naval power', 'History')");
            /* 90 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (" + Integer.toString(generateNumbers[89]) + ", 'In the period following World War II, the United States established a long term military presence in West Germany in an effort to:',"
            + " 'stop communist expansion in Europe', 'support the unification of Europe, by force if necessary', 'prevent the renewal of German aggression in Europe', 'allow the United Nations to resolve international disputes', 'History')");


            System.out.println("Data inserted into the database!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // create a Statement from the connection

// insert the data

    public int getRowCount(){
        int count = 0;
        try{
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM theDreamersTable");
            r.next();
            count = r.getInt("rowcount");
            r.close();
            System.out.println("MyTable has " + count + " row(s).");
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return count;
    }


}
