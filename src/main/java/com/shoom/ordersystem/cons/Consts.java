package com.shoom.ordersystem.cons;

/**
 * @author wangtao
 * @date 2023/4/7 20:47
 */
public class Consts {

    public static boolean TRUE = true;

    public static boolean FALSE = false;

    /**
     * 产品信息 目前以json写死
     */
    public static String products = "export const DATA_1 = [\n" +
            "  {\n" +
            "    id: 1_1,\n" +
            "    category: 'A',\n" +
            "    name: 'H01 熱咖啡 Hot HK Style Coffee',\n" +
            "    price: 3.95,\n" +
            "    image: require('../assets/noodle-plain.png'),\n" +
            "    rating: 5,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: true,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_2,\n" +
            "    category: 'A',\n" +
            "    name: 'H03 熱檸茶 Hot HK Style Lemon Tea',\n" +
            "    price: 3.95,\n" +
            "    image: require('../assets/tea-ice.png'),\n" +
            "    rating: 5,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: true,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_3,\n" +
            "    category: 'A',\n" +
            "    name: 'H04 熱檸水 Hot Lemon Water',\n" +
            "    price: 3.95,\n" +
            "    image: require('../assets/chocolate-ice.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_4,\n" +
            "    category: 'A',\n" +
            "    name: 'H05 熱杏霜 Hot Almond Tea',\n" +
            "    price: 3.95,\n" +
            "    image: require('../assets/coffee-black.png'),\n" +
            "    rating: 5,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: true,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_5,\n" +
            "    category: 'A',\n" +
            "    name: 'H06 熱阿華田 Hot Ovaltine',\n" +
            "    price: 3.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_6,\n" +
            "    category: 'A',\n" +
            "    name: 'H07 熱好立克 Hot Horlick',\n" +
            "    price: 3.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_7,\n" +
            "    category: 'A',\n" +
            "    name: 'H08 熱朱古力 Hot Chocolate',\n" +
            "    price: 3.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_8,\n" +
            "    category: 'A',\n" +
            "    name: 'H09 熱檸蜜 Hot Honey Lemon Water',\n" +
            "    price: 3.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_9,\n" +
            "    category: 'A',\n" +
            "    name: 'H10 汽水 Coke',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_10,\n" +
            "    category: 'A',\n" +
            "    name: 'I01 凍咖啡 Iced HK Style Coffee',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_11,\n" +
            "    category: 'A',\n" +
            "    name: 'I02 凍鴛鴦 Iced HK style Coffee Milk Tea',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_12,\n" +
            "    category: 'A',\n" +
            "    name: 'I03 凍檸茶 Iced HK Style Lemon Tea',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_13,\n" +
            "    category: 'A',\n" +
            "    name: 'I04 凍檸水 Iced Lemon Water',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_14,\n" +
            "    category: 'A',\n" +
            "    name: 'I05 凍杏霜 Iced Almond Tea',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_15,\n" +
            "    category: 'A',\n" +
            "    name: 'I06 凍阿華田 Iced Ovaltine',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_16,\n" +
            "    category: 'A',\n" +
            "    name: 'I07 凍好立克 Iced Horlick',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_17,\n" +
            "    category: 'A',\n" +
            "    name: 'I08 凍朱古力 Iced Chocolate',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_18,\n" +
            "    category: 'A',\n" +
            "    name: 'I09 凍檸蜜 Iced Honey Lemon Water',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_19,\n" +
            "    category: 'A',\n" +
            "    name: 'I10 凍檸樂 Iced Lemon Coke',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_20,\n" +
            "    category: 'A',\n" +
            "    name: '凍七啡 Special Iced Coffee Soda',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  },\n" +
            "  {\n" +
            "    id: 1_21,\n" +
            "    category: 'A',\n" +
            "    name: '咖啡七喜 - Coffee and Sprite Mix',\n" +
            "    price: 4.95,\n" +
            "    image: require('../assets/chocolate-hot.png'),\n" +
            "    rating: 4,\n" +
            "    description: 'SHOOM',\n" +
            "    isFavourite: false,\n" +
            "  }\n" +
            "];\n";
}
