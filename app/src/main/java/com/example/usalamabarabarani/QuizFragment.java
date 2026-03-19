package com.example.usalamabarabarani;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizFragment extends Fragment {

    private static class QuizQuestion {
        final String swali;
        final String[] chaguo;
        final int jibuSahihi; // index 0-3
        final String maelezo;

        QuizQuestion(String swali, String[] chaguo, int jibuSahihi, String maelezo) {
            this.swali = swali;
            this.chaguo = chaguo;
            this.jibuSahihi = jibuSahihi;
            this.maelezo = maelezo;
        }
    }

    private List<QuizQuestion> maswali;
    private int currentIndex = 0;
    private int score = 0;
    private boolean questionAnswered = false;

    private TextView questionTextView;
    private TextView progressTextView;
    private TextView resultTitleTextView;
    private TextView resultScoreTextView;
    private TextView resultMessageTextView;
    private View resultContainer;
    private Button option1Button;
    private Button option2Button;
    private Button option3Button;
    private Button option4Button;
    private Button nextButton;
    private Button retryButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        View backButton = view.findViewById(R.id.backButton);
        questionTextView = view.findViewById(R.id.questionTextView);
        progressTextView = view.findViewById(R.id.progressTextView);
        option1Button = view.findViewById(R.id.option1Button);
        option2Button = view.findViewById(R.id.option2Button);
        option3Button = view.findViewById(R.id.option3Button);
        option4Button = view.findViewById(R.id.option4Button);
        nextButton = view.findViewById(R.id.nextButton);
        resultContainer = view.findViewById(R.id.resultContainer);
        resultTitleTextView = view.findViewById(R.id.resultTitleTextView);
        resultScoreTextView = view.findViewById(R.id.resultScoreTextView);
        resultMessageTextView = view.findViewById(R.id.resultMessageTextView);
        retryButton = view.findViewById(R.id.retryButton);

        backButton.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());

        maswali = buildQuestions();
        Collections.shuffle(maswali);
        if (maswali.size() > 10) {
            maswali = new ArrayList<>(maswali.subList(0, 10));
        }

        setupQuestion();

        View.OnClickListener optionClickListener = v -> {
            if (questionAnswered) return;
            Button clicked = (Button) v;
            int selectedIndex = getSelectedIndex(clicked);
            checkAnswer(selectedIndex, clicked);
        };

        option1Button.setOnClickListener(optionClickListener);
        option2Button.setOnClickListener(optionClickListener);
        option3Button.setOnClickListener(optionClickListener);
        option4Button.setOnClickListener(optionClickListener);

        nextButton.setOnClickListener(v -> {
            if (!questionAnswered) {
                Toast.makeText(requireContext(), "Tafadhali chagua jibu kwanza.", Toast.LENGTH_SHORT).show();
                return;
            }
            currentIndex++;
            if (currentIndex >= maswali.size()) {
                showFinalScore();
            } else {
                setupQuestion();
            }
        });

        retryButton.setOnClickListener(v -> {
            score = 0;
            currentIndex = 0;
            resultContainer.setVisibility(View.GONE);
            enableOptions(true);
            maswali = buildQuestions();
            Collections.shuffle(maswali);
            if (maswali.size() > 10) {
                maswali = new ArrayList<>(maswali.subList(0, 10));
            }
            setupQuestion();
        });

        return view;
    }

    private List<QuizQuestion> buildQuestions() {
        List<QuizQuestion> list = new ArrayList<>();

        list.add(new QuizQuestion(
                "Kasi ya juu inayoruhusiwa kwa gari ndogo barabara kuu (highway) nchini Tanzania ni ipi isipokuwa imeonyeshwa vinginevyo?",
                new String[]{"80 km/h", "100 km/h", "120 km/h", "60 km/h"},
                1,
                "Kwa kawaida kasi ya juu barabara kuu kwa magari madogo ni 100 km/h isipokuwa alama za barabarani zikionyeshe vinginevyo."
        ));

        list.add(new QuizQuestion(
                "Unapokaribia taa za njia panda zenye mwanga wa njano unaowaka mfululizo, unatakiwa kufanya nini?",
                new String[]{"Kuongeza kasi upite haraka", "Kusimama na kusubiri kijani", "Kupunguza mwendo na kuendelea kwa uangalifu", "Kupuuza taa na kufuata askari"},
                2,
                "Mwanga wa njano una maana ya kupunguza mwendo na kuendelea kwa uangalifu ukiwa tayari kusimama kama hali itabadilika."
        ));

        list.add(new QuizQuestion(
                "Ni wakati gani unaruhusiwa kupita juu ya mstari mfululizo wa njano katikati ya barabara?",
                new String[]{"Kila wakati kama barabara ni wazi", "Wakati wa kupita gari lingine kwa haraka", "Kamwe hairuhusiwi", "Usiku pekee"},
                2,
                "Mstari mfululizo wa njano unaonyesha kuwa hupaswi kuvuka kwenda upande mwingine kwa ajili ya kupita."
        ));

        list.add(new QuizQuestion(
                "Unapokaribia kivuko cha waenda kwa miguu (zebra crossing) na kuna watu wanaosubiri kuvuka, unatakiwa kufanya nini?",
                new String[]{"Kuendelea kama kawaida", "Kuwapa ishara wavuke lakini usipunguze mwendo", "Kupunguza kasi na kusimama ukiwaruhusu wavuke", "Kuwapigia honi waondoke"},
                2,
                "Dereva anatakiwa kupunguza kasi na kusimama ili kuwaruhusu waenda kwa miguu kuvuka salama kwenye zebra crossing."
        ));

        list.add(new QuizQuestion(
                "Kutumia simu ya mkononi bila kifaa cha mikono huru (hands‑free) wakati unaendesha gari kunaruhusiwa lini?",
                new String[]{"Wakati umesimama kwenye taa nyekundu", "Wakati barabara haina magari", "Haifai kabisa wakati unaendesha", "Wakati unazungumza kwa ufupi"},
                2,
                "Sheria inakataza kutumia simu bila kifaa cha mikono huru wakati unaendesha, kwa usalama wako na watumiaji wengine wa barabara."
        ));

        list.add(new QuizQuestion(
                "Ni wajibu wa nani kufunga mkanda wa usalama (seat belt)?",
                new String[]{"Dereva pekee", "Abiria wa mbele pekee", "Dereva na abiria wote walioketi kwenye viti vyenye mikanda", "Hakuna anayelazimika"},
                2,
                "Sheria inataka dereva na abiria wote waliokaa kwenye viti vyenye mikanda wafunge mkanda wa usalama."
        ));

        list.add(new QuizQuestion(
                "Unapokaribia mzunguko wa barabara (roundabout) unapaswa kumpa kipaumbele nani?",
                new String[]{"Gari linaloingia kutoka kushoto", "Gari tayari lipo kwenye mzunguko", "Gari kubwa zaidi", "Yeyote anayewasha taa za hatari"},
                1,
                "Kipaumbele ni kwa magari ambayo tayari yako ndani ya roundabout; unapaswa kusubiri nafasi salama kabla ya kuingia."
        ));

        list.add(new QuizQuestion(
                "Dereva anaruhusiwa kuwa na kiwango gani cha kilevi (alcohol) mwilini wakati wa kuendesha?",
                new String[]{"Hakuna kiwango kinachokatazwa", "Kiasi kidogo hakina madhara", "Haipaswi kuendesha ukiwa umelewa au chini ya ushawishi wa kilevi", "Inaruhusiwa mchana tu"},
                2,
                "Sheria inapiga marufuku kuendesha ukiwa umelewa au chini ya ushawishi wa kilevi kwa usalama wa wote."
        ));

        list.add(new QuizQuestion(
                "Ni nini unapaswa kufanya kama unakumbwa na hitilafu ya gari barabarani (breakdown)?",
                new String[]{"Kuacha gari katikati ya barabara", "Kuweka alama za onyo na kuliweka gari pembeni kadri inavyowezekana", "Kuondoka haraka bila taarifa", "Kusubiri katikati ya njia mpaka msaada ufike"},
                1,
                "Weka gari pembeni kadri inavyowezekana, washa taa za hatari na tumia alama za onyo ili kuonya watumiaji wengine wa barabara."
        ));

        list.add(new QuizQuestion(
                "Kabla ya kubadilisha mwelekeo au kugeuka, unatakiwa kufanya nini?",
                new String[]{"Kuangalia tu mbele", "Kutumia kiashirio (indicator) na kuangalia vioo na kona bubu (blind spot)", "Kupunguza mwendo bila ishara", "Kupiga honi mara tatu"},
                1,
                "Ni muhimu kutoa ishara mapema, kuangalia vioo na kona bubu kabla ya kubadilisha mwelekeo ili kuepuka ajali."
        ));

        return list;
    }

    private void setupQuestion() {
        questionAnswered = false;
        enableOptions(true);
        nextButton.setEnabled(false);

        resetOptionColors();

        QuizQuestion q = maswali.get(currentIndex);
        questionTextView.setText(q.swali);
        progressTextView.setText("Swali " + (currentIndex + 1) + " kati ya " + maswali.size());

        option1Button.setText(q.chaguo[0]);
        option2Button.setText(q.chaguo[1]);
        option3Button.setText(q.chaguo[2]);
        option4Button.setText(q.chaguo[3]);
    }

    private int getSelectedIndex(Button button) {
        if (button == option1Button) return 0;
        if (button == option2Button) return 1;
        if (button == option3Button) return 2;
        return 3;
    }

    private void checkAnswer(int selectedIndex, Button clickedButton) {
        QuizQuestion q = maswali.get(currentIndex);
        questionAnswered = true;
        nextButton.setEnabled(true);
        enableOptions(false);
        Button correctButton = getButtonByIndex(q.jibuSahihi);

        int correctColor = ContextCompat.getColor(requireContext(), R.color.quiz_correct);
        int errorColor = ContextCompat.getColor(requireContext(), R.color.quiz_error);

        if (selectedIndex == q.jibuSahihi) {
            score++;
            correctButton.setBackgroundTintList(ColorStateList.valueOf(correctColor));
            Toast.makeText(requireContext(), "Sahihi! " + q.maelezo, Toast.LENGTH_LONG).show();
        } else {
            clickedButton.setBackgroundTintList(ColorStateList.valueOf(errorColor));
            correctButton.setBackgroundTintList(ColorStateList.valueOf(correctColor));
            Toast.makeText(requireContext(), "Si sahihi. Jibu sahihi: " + q.chaguo[q.jibuSahihi] + ". " + q.maelezo, Toast.LENGTH_LONG).show();
        }
    }

    private void enableOptions(boolean enabled) {
        option1Button.setEnabled(enabled);
        option2Button.setEnabled(enabled);
        option3Button.setEnabled(enabled);
        option4Button.setEnabled(enabled);
    }

    private void resetOptionColors() {
        int primaryColor = ContextCompat.getColor(requireContext(), R.color.primary);
        ColorStateList primaryTint = ColorStateList.valueOf(primaryColor);
        option1Button.setBackgroundTintList(primaryTint);
        option2Button.setBackgroundTintList(primaryTint);
        option3Button.setBackgroundTintList(primaryTint);
        option4Button.setBackgroundTintList(primaryTint);
    }

    private Button getButtonByIndex(int index) {
        switch (index) {
            case 0:
                return option1Button;
            case 1:
                return option2Button;
            case 2:
                return option3Button;
            case 3:
            default:
                return option4Button;
        }
    }

    private void showFinalScore() {
        enableOptions(false);
        nextButton.setEnabled(false);
        resultContainer.setVisibility(View.VISIBLE);

        int total = maswali.size();
        int percent = (int) ((score / (float) total) * 100);

        resultTitleTextView.setText("Matokeo ya Jaribio");
        resultScoreTextView.setText("Alama zako: " + score + " kati ya " + total + " (" + percent + "%)");

        String msg;
        if (percent >= 80) {
            msg = "Hongera! Umefanya vizuri sana. Una uelewa mzuri wa sheria za barabarani.";
        } else if (percent >= 50) {
            msg = "Umefanya vizuri, lakini bado unaweza kuboresha uelewa wako wa sheria za barabarani.";
        } else {
            msg = "Inapendekezwa ufanye marejeo zaidi ya sheria za barabarani ili kuongeza usalama wako.";
        }
        resultMessageTextView.setText(msg);
    }
}

