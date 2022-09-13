package com.taewan.shop;

import com.taewan.shop.domain.Category;
import com.taewan.shop.domain.Item;
import com.taewan.shop.domain.Member;
import com.taewan.shop.domain.UploadFile;
import com.taewan.shop.repository.CategoryRepository;
import com.taewan.shop.repository.ItemRepository;
import com.taewan.shop.repository.MemberRepository;
import com.taewan.shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void initCategories() {
        initService.initCategory();
        initService.initItemDB();
        initService.initMemberDb();

        initService.updateCategory();

    }


    @Component
    @RequiredArgsConstructor
    @Transactional
    static class InitService {
        private final CategoryRepository categoryRepository;

        private final CategoryService categoryService;
        private final ItemRepository itemRepository;
        private final MemberRepository memberRepository;

        public void updateCategory(){
            categoryService.updateCategory();
        }

        public void initCategory() {


            List<Category> all = categoryRepository.findAll();

            Long sequance_id = 0L;

            if (all.size() >= 1) {
                return;
            }

            Category category1 = new Category("강아지 식품", 1L, 0L);
            categoryRepository.save(category1);

            Category category2 = new Category("패드/미용", 2L, 0L);
            categoryRepository.save(category2);

            Category category3 = new Category("의류/가슴줄,훈련도구", 3L, 0L);
            categoryRepository.save(category3);

            Category category4 = new Category("건강관리", 4L, 1L);
            categoryRepository.save(category4);

            Category category5 = new Category("패드/장난감", 5L, 2L);
            categoryRepository.save(category5);

            Category category6 = new Category("의류,액세서리", 6L, 3L);
            categoryRepository.save(category6);

            Category category7 = new Category("사료/간식", 7L, 1L);
            categoryRepository.save(category7);

            Category category8 = new Category("미용", 8L, 2L);
            categoryRepository.save(category8);

            Category category9 = new Category("가슴줄,훈련도구", 9L, 3L);
            categoryRepository.save(category9);





        }

        public void initMemberDb(){
            List<Member> all = memberRepository.findAll();
            if (all.size() != 0) {
                return;
            }
            Member member = new Member("test", "test!", "test", null);
            member.setAdmin(true);
            memberRepository.save(member);
        }


        public void initItemDB() {

            List<Item> all = itemRepository.findAll();
            if (all.size() > 0) {
                return;
            }

            Item item = new Item(20000, 10000, 55, 5,
                    new UploadFile("업로드.png", "healthcare1.jpg"), categoryService.findCategoryByName("건강관리")
                    , "데에스포 에이치시리즈 관절 250g");
            Item item2 = new Item(14000, 8800, 55, 5,
                    new UploadFile("업로드.png", "healthcare2.jpg"), categoryService.findCategoryByName("건강관리"),
                    "인트라젠 종합영양제 타블렛 200정");
            Item item3 = new Item(17000, 9900, 55, 5,
                    new UploadFile("업로드.png", "healthcare3.jpg"), categoryService.findCategoryByName("건강관리"),
                    "버박 C.E.T. 치약 닭고기맛 70g");
            Item item4 = new Item(55000, 49500, 55, 5,
                    new UploadFile("업로드.png", "healthcare4.jpg"), categoryService.findCategoryByName("건강관리"),
                    "리얼 비피더스 독120g");
            Item item5 = new Item(18000, 14500, 55, 5,
                    new UploadFile("업로드.png", "healthcare5.jpg"), categoryService.findCategoryByName("건강관리"),
                    "버박 에피오틱 귀 세정제 125ml");
            Item item6 = new Item(24000, 22700, 55, 4,
                    new UploadFile("업로드.png", "healthcare6.jpg"), categoryService.findCategoryByName("건강관리"),
                    "자이목스 오라틴 투스페이스트젤 70g");
            Item item7 = new Item(26000, 0, 55, 4,
                    new UploadFile("업로드.png", "healthcare7.jpg"), categoryService.findCategoryByName("건강관리"),
                    "뉴트리벳 프리&프로바이오틱스 츄어블120정");
            Item item8 = new Item(20000, 10000, 55, 4,
                    new UploadFile("업로드.png", "healthcare8.jpg"), categoryService.findCategoryByName("건강관리"),
                    "데이스포 에이치시리즈 종합영양 250g");



            itemRepository.save(item);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
            itemRepository.save(item5);
            itemRepository.save(item6);
            itemRepository.save(item7);
            itemRepository.save(item8);

            initItemDB2();
            initItemDB3();
            initItemDB4();
            initItemDB5();
            initItemDB6();
            initItemDB7();



        }

        public void initItemDB2() {



            Item item = new Item(20000, 10000, 55, 5,
                    new UploadFile("업로드.png", "healthcare1.jpg"), categoryService.findCategoryByName("건강관리")
                    , "데에스포 에이치시리즈 관절 250g");
            Item item2 = new Item(14000, 8800, 55, 5,
                    new UploadFile("업로드.png", "healthcare2.jpg"), categoryService.findCategoryByName("건강관리"),
                    "인트라젠 종합영양제 타블렛 200정");
            Item item3 = new Item(17000, 9900, 55, 5,
                    new UploadFile("업로드.png", "healthcare3.jpg"), categoryService.findCategoryByName("건강관리"),
                    "버박 C.E.T. 치약 닭고기맛 70g");
            Item item4 = new Item(55000, 49500, 55, 5,
                    new UploadFile("업로드.png", "healthcare4.jpg"), categoryService.findCategoryByName("건강관리"),
                    "리얼 비피더스 독120g");
            Item item5 = new Item(18000, 14500, 55, 5,
                    new UploadFile("업로드.png", "healthcare5.jpg"), categoryService.findCategoryByName("건강관리"),
                    "버박 에피오틱 귀 세정제 125ml");
            Item item6 = new Item(24000, 22700, 55, 4,
                    new UploadFile("업로드.png", "healthcare6.jpg"), categoryService.findCategoryByName("건강관리"),
                    "자이목스 오라틴 투스페이스트젤 70g");
            Item item7 = new Item(26000, 0, 55, 4,
                    new UploadFile("업로드.png", "healthcare7.jpg"), categoryService.findCategoryByName("건강관리"),
                    "뉴트리벳 프리&프로바이오틱스 츄어블120정");
            Item item8 = new Item(20000, 10000, 55, 4,
                    new UploadFile("업로드.png", "healthcare8.jpg"), categoryService.findCategoryByName("건강관리"),
                    "데이스포 에이치시리즈 종합영양 250g");



            itemRepository.save(item);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
            itemRepository.save(item5);
            itemRepository.save(item6);
            itemRepository.save(item7);
            itemRepository.save(item8);


        }

        public void initItemDB3() {



            Item item = new Item(11000, 11000, 55, 1,
                    new UploadFile("업로드.png", "dog1.jpg"), categoryService.findCategoryByName("가슴줄,훈련도구")
                    , "지엠펫 메쉬 반사 하네스 세트 형광");
            Item item2 = new Item(18000, 18000, 55, 2,
                    new UploadFile("업로드.png", "dog2.jpg"), categoryService.findCategoryByName("가슴줄,훈련도구"),
                    "플렉시 뉴클래식 바리오 자동줄 코드타입");
            Item item3 = new Item(10000, 7600, 55, 0,
                    new UploadFile("업로드.png", "dog3.jpg"), categoryService.findCategoryByName("가슴줄,훈련도구"),
                    "애드펫 민자 가죽목줄 스카이블루");
            Item item4 = new Item(210, 50, 55, 3,
                    new UploadFile("업로드.png", "dog4.jpg"), categoryService.findCategoryByName("가슴줄,훈련도구"),
                    "응급구조 자석 스티커");
            Item item5 = new Item(19000, 18000, 55, 4,
                    new UploadFile("업로드.png", "dog5.jpg"), categoryService.findCategoryByName("가슴줄,훈련도구"),
                    "유린오프 얼룩 냄새 제거제");
            Item item6 = new Item(2900, 1900, 55, 3,
                    new UploadFile("업로드.png", "dog6.jpg"), categoryService.findCategoryByName("가슴줄,훈련도구"),
                    "반려동물 다용도 실리콘 뚜껑");
            Item item7 = new Item(12000, 12000, 55, 5,
                    new UploadFile("업로드.png", "dog7.jpg"), categoryService.findCategoryByName("가슴줄,훈련도구"),
                    "뽀솜 반려동물 전용 섬유유연제");
            Item item8 = new Item(57000, 49000, 55, 5,
                    new UploadFile("업로드.png", "dog8.jpg"), categoryService.findCategoryByName("가슴줄,훈련도구"),
                    "펭카 홈 카메라");

            itemRepository.save(item);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
            itemRepository.save(item5);
            itemRepository.save(item6);
            itemRepository.save(item7);
            itemRepository.save(item8);


        }

        public void initItemDB4() {



            Item item = new Item(57900, 52110, 55, 1,
                    new UploadFile("업로드.png", "dogfood1.jpg"), categoryService.findCategoryByName("사료/간식")
                    , "소고기&연어 5.6kg");
            Item item2 = new Item(66000, 49900, 55, 2,
                    new UploadFile("업로드.png", "dogfood2.jpg"), categoryService.findCategoryByName("사료/간식"),
                    "네츄럴코어 오리&고구마 6kg");
            Item item3 = new Item(46300, 38500, 55, 0,
                    new UploadFile("업로드.png", "dogfood3.jpg"), categoryService.findCategoryByName("사료/간식"),
                    "로얄캐닌 푸들 어덜트 3kg 피모관리");
            Item item4 = new Item(83000, 79000, 55, 3,
                    new UploadFile("업로드.png", "dogfood4.jpg"), categoryService.findCategoryByName("사료/간식"),
                    "로얄캐닌 미니 인도어 어덜트 8.7kg 소화기 건강");
            Item item5 = new Item(55000, 32000, 55, 4,
                    new UploadFile("업로드.png", "dogsnack1.jpg"), categoryService.findCategoryByName("사료/간식"),
                    "카누들 플러스 덴탈껌 S 소형견용 100개");
            Item item6 = new Item(2500, 2000, 55, 3,
                    new UploadFile("업로드.png", "dogsnack2.jpg"), categoryService.findCategoryByName("사료/간식"),
                    "카리에스 덴탈껌 6개입");
            Item item7 = new Item(5000, 3300, 55, 5,
                    new UploadFile("업로드.png", "dogsnack3.jpg"), categoryService.findCategoryByName("사료/간식"),
                    "네츄럴코어 하루유산균 혼합 12개입");
            Item item8 = new Item(5500, 5300, 55, 5,
                    new UploadFile("업로드.png", "dogsnack4.jpg"), categoryService.findCategoryByName("사료/간식"),
                    "페페로니 진짜 오메가3 연어 180g");


            itemRepository.save(item);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
            itemRepository.save(item5);
            itemRepository.save(item6);
            itemRepository.save(item7);
            itemRepository.save(item8);


        }

        public void initItemDB5() {



            Item item = new Item(10500, 10500, 55, 1,
                    new UploadFile("업로드.png", "dogpad1.jpg"), categoryService.findCategoryByName("패드/장난감")
                    , "흡수혁명 애견패드 소형 50매");
            Item item2 = new Item(10000, 10000, 55, 2,
                    new UploadFile("업로드.png", "dogpad2.jpg"), categoryService.findCategoryByName("패드/장난감"),
                    "흡수혁명 애견패드 대형 20매");
            Item item3 = new Item(9900, 9900, 55, 0,
                    new UploadFile("업로드.png", "dogpad3.jpg"), categoryService.findCategoryByName("패드/장난감"),
                    "웁스백 배변봉투 120매");
            Item item4 = new Item(6900, 6900, 55, 3,
                    new UploadFile("업로드.png", "dogpad4.jpg"), categoryService.findCategoryByName("패드/장난감"),
                    "요요쉬 수컷용 매너밴드 기저귀 10매");
            Item item5 = new Item(5000, 5000, 55, 4,
                    new UploadFile("업로드.png", "dogpad5.jpg"), categoryService.findCategoryByName("패드/장난감"),
                    "구루머스 탈취제 1L");
            Item item6 = new Item(900, 900, 55, 3,
                    new UploadFile("업로드.png", "dogtoy6.jpg"), categoryService.findCategoryByName("패드/장난감"),
                    "펫모닝 로프토이 미니");
            Item item7 = new Item(4900, 4900, 55, 5,
                    new UploadFile("업로드.png", "dogtoy7.jpg"), categoryService.findCategoryByName("패드/장난감"),
                    "도기맨 IQ 스낵볼 장난감 S");
            Item item8 = new Item(2000, 2000, 55, 5,
                    new UploadFile("업로드.png", "dogtoy8.jpg"), categoryService.findCategoryByName("패드/장난감"),
                    "쏘아베 탱탱볼 대형");

            itemRepository.save(item);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
            itemRepository.save(item5);
            itemRepository.save(item6);
            itemRepository.save(item7);
            itemRepository.save(item8);


        }

        public void initItemDB6() {



            Item item = new Item(11000, 11000, 55, 1,
                    new UploadFile("업로드.png", "dogbeauty1.jpg"), categoryService.findCategoryByName("미용")
                    , "후레쉬앤클린 샴푸");
            Item item2 = new Item(9000, 9000, 55, 2,
                    new UploadFile("업로드.png", "dogbeauty2.jpg"), categoryService.findCategoryByName("미용"),
                    "도기맨 허니스마일 발톱깎이");
            Item item3 = new Item(15000, 8500, 55, 0,
                    new UploadFile("업로드.png", "dogbeauty3.jpg"), categoryService.findCategoryByName("미용"),
                    "쉐드킬러 브러쉬 죽은털제거");
            Item item4 = new Item(8000, 7500, 55, 3,
                    new UploadFile("업로드.png", "dogbeauty4.jpg"), categoryService.findCategoryByName("미용"),
                    "루커스 커트 민자가위");
            Item item5 = new Item(8000, 5000, 55, 4,
                    new UploadFile("업로드.png", "dogbeauty5.jpg"), categoryService.findCategoryByName("미용"),
                    "쏘아베 약용샴푸 비듬&피부질환방지 500ml");
            Item item6 = new Item(12000, 6000, 55, 3,
                    new UploadFile("업로드.png", "dogbeauty6.jpg"), categoryService.findCategoryByName("미용"),
                    "굿프랜드 펫타월 핑크");
            Item item7 = new Item(11000, 11000, 55, 5,
                    new UploadFile("업로드.png", "dogbeauty7.jpg"), categoryService.findCategoryByName("미용"),
                    "도기맨 허니스마일 핀 브러쉬");
            Item item8 = new Item(7000, 6000, 55, 5,
                    new UploadFile("업로드.png", "dogbeauty8.jpg"), categoryService.findCategoryByName("미용"),
                    "리케이 네일파일 발톱 다듬기용");

            itemRepository.save(item);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
            itemRepository.save(item5);
            itemRepository.save(item6);
            itemRepository.save(item7);
            itemRepository.save(item8);


        }

        public void initItemDB7() {



            Item item = new Item(5000, 5000, 55, 1,
                    new UploadFile("업로드.png", "dogclothing1.jpg"), categoryService.findCategoryByName("의류,액세서리")
                    , "캔디칼라 라텍스부츠 블랙");
            Item item2 = new Item(17000, 17000, 55, 2,
                    new UploadFile("업로드.png", "dogclothing2.jpg"), categoryService.findCategoryByName("의류,액세서리"),
                    "플로트 스탠다드 골지 티셔츠 레드");
            Item item3 = new Item(17500, 17500, 55, 0,
                    new UploadFile("업로드.png", "dogclothing3.jpg"), categoryService.findCategoryByName("의류,액세서리"),
                    "빛돌 심플 베이직 패딩 베스트 네이비");
            Item item4 = new Item(36000, 36000, 55, 3,
                    new UploadFile("업로드.png", "dogclothing4.jpg"), categoryService.findCategoryByName("의류,액세서리"),
                    "이츠독 후르츠 구명조끼 수박");
            Item item5 = new Item(40000, 29900, 55, 4,
                    new UploadFile("업로드.png", "dogclothing5.jpg"), categoryService.findCategoryByName("의류,액세서리"),
                    "닥터펫 패션 이동가방 옐로우");
            Item item6 = new Item(90000, 79000, 55, 3,
                    new UploadFile("업로드.png", "dogclothing6.jpg"), categoryService.findCategoryByName("의류,액세서리"),
                    "아이리스 트레블 캐리어");
            Item item7 = new Item(19900, 19900, 55, 5,
                    new UploadFile("업로드.png", "dogclothing7.jpg"), categoryService.findCategoryByName("의류,액세서리"),
                    "울리 모던 슬링백 데님");
            Item item8 = new Item(259000, 199000, 55, 5,
                    new UploadFile("업로드.png", "dogclothing8.jpg"), categoryService.findCategoryByName("의류,액세서리"),
                    "낫쏘빅 도로시 펫유모차");

            itemRepository.save(item);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
            itemRepository.save(item5);
            itemRepository.save(item6);
            itemRepository.save(item7);
            itemRepository.save(item8);


        }



        //카테고리 DB


    }

}
